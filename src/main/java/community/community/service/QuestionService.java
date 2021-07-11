package community.community.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import community.community.dto.PaginationDTO;
import community.community.dto.QuestionDTO;
import community.community.exception.CustomizeErrorCode;
import community.community.exception.CustomizeException;
import community.community.mapper.QuestionExtMapper;
import community.community.mapper.QuestionMapper;
import community.community.mapper.UserAccountMapper;
import community.community.model.Question;
import community.community.model.QuestionExample;
import community.community.model.UserAccount;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionMapper questionMapper;
	
	@Autowired
	private UserAccountMapper userAccountMapper;
	
	@Autowired
	private QuestionExtMapper questionExtMapper;
	
	
	
	public PaginationDTO list(Integer page, Integer size) {
		PaginationDTO paginationDTO = new PaginationDTO();
		
		Integer totalPage;
		
		Integer totalCount = (int) questionMapper.countByExample(new QuestionExample());
		
		if(totalCount % size == 0) {
			totalPage = totalCount / size;
		}else {
			totalPage = (totalCount / size) + 1;
		}
		
		if(page<1) {
			page = 1;
		}
		
		if(page>totalPage){
			page = totalPage;
		}
		paginationDTO.setPagination(totalPage,page);
		Integer offset = size*(page-1);
		List<Question> questions = questionMapper.selectByExampleWithRowbounds(new QuestionExample(), new RowBounds());
		List<QuestionDTO> questionDTOList = new ArrayList<QuestionDTO>();
		
		for(Question question :questions) {
			UserAccount userAccount = userAccountMapper.selectByPrimaryKey(question.getCreator());
			QuestionDTO questionDTO = new QuestionDTO();
			BeanUtils.copyProperties(question, questionDTO);
			questionDTO.setUserAccount(userAccount);
			questionDTOList.add(questionDTO);
		}
		paginationDTO.setQuestions(questionDTOList);
		return paginationDTO;
	}
	
	public PaginationDTO list(Long userId,Integer page,Integer size) {
		PaginationDTO paginationDTO = new PaginationDTO();
		
		Integer totalPage;
		
		QuestionExample questionExample = new QuestionExample();
		questionExample.createCriteria().andCreatorEqualTo(userId);
		Integer totalCount = (int) questionMapper.countByExample(new QuestionExample());
		
		if(totalCount % size == 0) {
			totalPage = totalCount / size;
		}else {
			totalPage = (totalCount / size) + 1;
		}
		
		if(page<1) {
			page = 1;
		}
		
		if(page>totalPage){
			page = totalPage;
		}
		
		paginationDTO.setPagination(totalPage,page);
		Integer offset = size*(page-1);
		QuestionExample example = new QuestionExample();
		example.createCriteria().andCreatorEqualTo(userId);
		List<Question> questions = questionMapper.selectByExampleWithRowbounds(example, new RowBounds());
		List<QuestionDTO> questionDTOList = new ArrayList<QuestionDTO>();
		
		for(Question question :questions) {
			UserAccount userAccount = userAccountMapper.selectByPrimaryKey(question.getCreator());
			QuestionDTO questionDTO = new QuestionDTO();
			BeanUtils.copyProperties(question, questionDTO);
			questionDTO.setUserAccount(userAccount);
			questionDTOList.add(questionDTO);
		}
		paginationDTO.setQuestions(questionDTOList);
		return paginationDTO;
	}

	public QuestionDTO getById(Long id) {
		Question question = questionMapper.selectByPrimaryKey(id);
		QuestionDTO questionDTO = new QuestionDTO();
		BeanUtils.copyProperties(question, questionDTO);
		UserAccount userAccount = userAccountMapper.selectByPrimaryKey(question.getCreator());
		questionDTO.setUserAccount(userAccount);
		return questionDTO;
	}

	public void createOrUpdate(Question question) {
		if(question.getId() == null) {
			//創建
			question.setGmtCreate(System.currentTimeMillis());
			question.setGmtModified(question.getGmtCreate());
			question.setViewCount(0);
			question.setCommentCount(0);
			question.setLikeCount(0);
			questionMapper.insert(question);
		}else {
			//更新
			Question updateQuestion = new Question();
			updateQuestion.setGmtModified(System.currentTimeMillis());
			updateQuestion.setTitle(question.getTitle());
			updateQuestion.setDescription(question.getDescription());
			updateQuestion.setTag(question.getTag());
			QuestionExample questionExample = new QuestionExample();
			questionExample.createCriteria().andIdEqualTo(question.getId());
			int updated = questionMapper.updateByExampleSelective(updateQuestion, questionExample);
			if(updated != 1) {
				throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
			}
		}
		
	}

	public void incView(Long id) {	
		Question question = new Question();
		question.setId(id);
		question.setViewCount(1); 
		questionExtMapper.incView(question);
	}
	
	public List<QuestionDTO> selectRelated(QuestionDTO queryDTO) {
        if (StringUtils.isBlank(queryDTO.getTag())) {
            return new ArrayList<>();
        }
        String[] tags = StringUtils.split(queryDTO.getTag(), ",");
        String regexpTag = Arrays
                .stream(tags)
                .filter(StringUtils::isNotBlank)
                .map(t -> t.replace("+", "").replace("*", "").replace("?", ""))
                .filter(StringUtils::isNotBlank)
                .collect(Collectors.joining("|"));
        Question question = new Question();
        question.setId(queryDTO.getId());
        question.setTag(regexpTag);

        List<Question> questions = questionExtMapper.selectRelated(question);
        List<QuestionDTO> questionDTOS = questions.stream().map(q -> {
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(q, questionDTO);
            return questionDTO;
        }).collect(Collectors.toList());
        return questionDTOS;
    }
}
