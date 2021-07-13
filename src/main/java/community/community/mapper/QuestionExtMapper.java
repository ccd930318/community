package community.community.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import community.community.dto.QuestionQueryDTO;
import community.community.model.Question;

@Mapper
public interface QuestionExtMapper {
	int incView(Question record);
	int incCommentCount(Question record);
	List<Question> selectRelated(Question question);
	Integer countBySearch(QuestionQueryDTO questionQueryDTO);
	List<Question> selectBySearch(QuestionQueryDTO questionQueryDTO);
}
