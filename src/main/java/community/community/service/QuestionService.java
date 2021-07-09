package community.community.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import community.community.dto.PaginationDTO;
import community.community.dto.QuestionDTO;
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
	
	public PaginationDTO list(Integer userId,Integer page,Integer size) {
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

	public QuestionDTO getById(Integer id) {
		Question question = questionMapper.selectByPrimaryKey(id);
		QuestionDTO questionDTO = new QuestionDTO();
		BeanUtils.copyProperties(question, questionDTO);
		UserAccount userAccount = userAccountMapper.selectByPrimaryKey(question.getCreator());
		questionDTO.setUserAccount(userAccount);
		return questionDTO;
	}

	public void createOrUpdate(Question question) {
		if(question.getId() == null) {
			question.setGmtCreate(System.currentTimeMillis());
			question.setGmtModified(question.getGmtCreate());
			questionMapper.insert(question);
		}else {
			Question updateQuestion = new Question();
			question.setGmtModified(question.getGmtCreate());
			question.setTitle(question.getTitle());
			question.setDescription(question.getDescription());
			question.setTag(question.getTag());
			QuestionExample questionExample = new QuestionExample();
			questionExample.createCriteria().andIdEqualTo(question.getId());
			questionMapper.updateByExampleSelective(updateQuestion, questionExample);
		}
		
	}
}
