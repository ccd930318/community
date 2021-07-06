package community.community.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import community.community.dto.PaginationDTO;
import community.community.dto.QuestionDTO;
import community.community.mapper.QuestionMapper;
import community.community.mapper.UserAccountMapper;
import community.community.mapper.UserMapper;
import community.community.model.Question;
import community.community.model.User;
import community.community.model.UserAccount;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionMapper questionMapper;
	
	@Autowired
	private UserAccountMapper userAccountMapper;
	
	
	
	public PaginationDTO list(Integer page, Integer size) {
PaginationDTO paginationDTO = new PaginationDTO();
		
		Integer totalPage;
		
		Integer totalCount = questionMapper.count();
		
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
		List<Question> questions = questionMapper.list(offset,size);
		List<QuestionDTO> questionDTOList = new ArrayList<QuestionDTO>();
		
		for(Question question :questions) {
			UserAccount userAccount = userAccountMapper.findById(question.getCreator());
			QuestionDTO questionDTO = new QuestionDTO();
			BeanUtils.copyProperties(question, questionDTO);
			questionDTO.setUserAccount(userAccount);
			questionDTOList.add(questionDTO);
		}
		paginationDTO.setQuestions(questionDTOList);
		return paginationDTO;
	}
	
	public PaginationDTO list(Integer userId,Integer page,Integer size) {
		PaginationDTO paginationDTO = new PaginationDTO();
		
		Integer totalPage;
		
		Integer totalCount = questionMapper.countByUserId(userId);
		
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
		List<Question> questions = questionMapper.listByUserId(userId,offset,size);
		List<QuestionDTO> questionDTOList = new ArrayList<QuestionDTO>();
		
		for(Question question :questions) {
			UserAccount userAccount = userAccountMapper.findById(question.getCreator());
			QuestionDTO questionDTO = new QuestionDTO();
			BeanUtils.copyProperties(question, questionDTO);
			questionDTO.setUserAccount(userAccount);
			questionDTOList.add(questionDTO);
		}
		paginationDTO.setQuestions(questionDTOList);
		return paginationDTO;
	}

	public QuestionDTO getById(Integer id) {
		Question question = questionMapper.getById(id);
		QuestionDTO questionDTO = new QuestionDTO();
		BeanUtils.copyProperties(question, questionDTO);
		UserAccount userAccount = userAccountMapper.findById(question.getCreator());
		questionDTO.setUserAccount(userAccount);
		return questionDTO;
	}
}
