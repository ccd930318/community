package community.community.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.comments.CommentType;
import community.community.dto.CommentDTO;
import community.community.enums.CommentTypeEnum;
import community.community.enums.NotificationStatusEnum;
import community.community.enums.NotificationTypeEnum;
import community.community.exception.CustomizeErrorCode;
import community.community.exception.CustomizeException;
import community.community.mapper.CommentExtMapper;
import community.community.mapper.CommentMapper;
import community.community.mapper.NotificationMapper;
import community.community.mapper.QuestionExtMapper;
import community.community.mapper.QuestionMapper;
import community.community.mapper.UserAccountMapper;
import community.community.model.Comment;
import community.community.model.CommentExample;
import community.community.model.Notification;
import community.community.model.Question;
import community.community.model.UserAccount;
import community.community.model.UserAccountExample;

@Service
public class CommentService {
	
	@Autowired
	private CommentMapper commentMapper;
	
	@Autowired
	private QuestionMapper questionMapper;
	
	@Autowired
	private QuestionExtMapper questionExtMapper;
	
	@Autowired
	private UserAccountMapper userAccountMapper;
	
    @Autowired
    private CommentExtMapper commentExtMapper;
    
    @Autowired
    private NotificationMapper notificationMapper;
	
	@Transactional
	public void insert(Comment comment,UserAccount commentator) {
		if(comment.getParentId()== null || comment.getParentId() == 0) {
			throw new CustomizeException(CustomizeErrorCode.TARGET_PARAM_NOT_FOUND);
		}
		
		if(comment.getType() == null || !CommentTypeEnum.isExist(comment.getType())) {
			throw new CustomizeException(CustomizeErrorCode.TYPE_PARAM_WRONG);
		}
		
		if(comment.getType() == CommentTypeEnum.COMMENT.getType()) {
			//回覆評論
            Comment dbComment = commentMapper.selectByPrimaryKey(comment.getParentId());
            if (dbComment == null) {
                throw new CustomizeException(CustomizeErrorCode.COMMENT_NOT_FOUND);
            }

            // 回覆問題
            Question question = questionMapper.selectByPrimaryKey(dbComment.getParentId());
            if (question == null) {
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }

            commentMapper.insert(comment);

            // 增加回覆數
            Comment parentComment = new Comment();
            parentComment.setId(comment.getParentId());
            parentComment.setCommentCount(1);
            commentExtMapper.incCommentCount(parentComment);
            
            //創建通知
            createNotify(comment,dbComment.getCommentator(),commentator.getName(),question.getTitle(),NotificationTypeEnum.REPLY_COMMENT,question.getId());
            
		}else {
			//回覆問題
            Question question = questionMapper.selectByPrimaryKey(comment.getParentId());
            if (question == null) {
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
            comment.setCommentCount(0);
            commentMapper.insert(comment);
            question.setCommentCount(1);
            questionExtMapper.incCommentCount(question);
            
            //創建通知
            createNotify(comment,question.getCreator(),commentator.getName(),question.getTitle(),NotificationTypeEnum.REPLY_QUESTION,question.getId());
			
		}
	}
	
	private void createNotify(Comment comment,Long receiver,String notifierName,String outerTitle,NotificationTypeEnum notificationType,Long outerId) {
		if(receiver == comment.getCommentator()) {
			return ;
		}
		Notification notification = new Notification();
        notification.setOuterid(outerId);
        notification.setGmtCreate(System.currentTimeMillis());
        notification.setType(notificationType.getType());
        notification.setNotifier(comment.getCommentator());
        notification.setStatus(NotificationStatusEnum.UNREAD.getStatus());
        notification.setReceiver(receiver);
        notification.setNotifierName(notifierName);
        notification.setOuterTitle(outerTitle);
        
        notificationMapper.insert(notification);
	}

	public List<CommentDTO> listByTargetId(Long id, CommentTypeEnum type){
        CommentExample commentExample = new CommentExample();
        commentExample.createCriteria()
                .andParentIdEqualTo(id)
                .andTypeEqualTo(type.getType());
        commentExample.setOrderByClause("gmt_create");
        List<Comment> comments = commentMapper.selectByExample(commentExample);

        if (comments.size() == 0) {
            return new ArrayList<>();
        }
        // 拿到並去掉重複的人
        Set<Long> commentators = comments.stream().map(comment -> comment.getCommentator()).collect(Collectors.toSet());
        List<Long> userIds = new ArrayList();
        userIds.addAll(commentators);


        // 得到評論人並轉換成MAP
        UserAccountExample userExample = new UserAccountExample();
        userExample.createCriteria()
                .andIdIn(userIds);
        List<UserAccount> users = userAccountMapper.selectByExample(userExample);
        Map<Long, UserAccount> userMap = users.stream().collect(Collectors.toMap(userAccount -> userAccount.getId(), user -> user));


        // 轉換comment 成  commentDTO
        List<CommentDTO> commentDTOS = comments.stream().map(comment -> {
            CommentDTO commentDTO = new CommentDTO();
            BeanUtils.copyProperties(comment, commentDTO);
            commentDTO.setUserAccount(userMap.get(comment.getCommentator()));
            return commentDTO;
        }).collect(Collectors.toList());

        return commentDTOS;
	}
	
	
	
}
