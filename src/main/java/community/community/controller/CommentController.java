package community.community.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import community.community.dto.CommentCreateDTO;
import community.community.dto.CommentDTO;
import community.community.dto.ResultDTO;
import community.community.enums.CommentTypeEnum;
import community.community.exception.CustomizeErrorCode;
import community.community.mapper.CommentMapper;
import community.community.model.Comment;
import community.community.model.UserAccount;
import community.community.service.CommentService;



@Controller
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@ResponseBody
	@RequestMapping(value="/comment",method = RequestMethod.POST)
	public Object post(@RequestBody CommentCreateDTO commentDTO,HttpServletRequest request) {
		UserAccount user =(UserAccount) request.getSession().getAttribute("userAccount");
		if(user == null) {
			return ResultDTO.errorOf(CustomizeErrorCode.NO_LOGIN);
		}
		if(commentDTO == null || commentDTO.getContent() == null || commentDTO.getContent() == "") {
			return ResultDTO.errorOf(CustomizeErrorCode.CONTENT_IS_EMPTY);
		}
		
		Comment comment = new Comment();
		comment.setParentId(commentDTO.getParentId());
		comment.setContent(commentDTO.getContent());
		comment.setType(commentDTO.getType());
		comment.setGmtCreate(System.currentTimeMillis());
		comment.setGmtModified(System.currentTimeMillis());
		comment.setCommentator(user.getId());
		comment.setLikeCount(0L);
		commentService.insert(comment);
		return ResultDTO.okOf();
	}
	
	    @ResponseBody
	    @RequestMapping(value = "/comment/{id}", method = RequestMethod.GET)
	    public ResultDTO<List<CommentDTO>> comments(@PathVariable(name = "id") Long id) {
	        List<CommentDTO> commentDTOS = commentService.listByTargetId(id, CommentTypeEnum.COMMENT);
	        return ResultDTO.okOf(commentDTOS);
	    }
}
