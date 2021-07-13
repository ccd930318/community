package community.community.mapper;

import org.apache.ibatis.annotations.Mapper;

import community.community.model.Comment;

@Mapper
public interface CommentExtMapper {
	int incCommentCount(Comment comment);
}
