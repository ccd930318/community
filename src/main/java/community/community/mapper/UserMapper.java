package community.community.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import community.community.model.User;

@Mapper
public interface UserMapper {
	@Insert("insert into user (name,account_id,token,gmt_create,gmt_modified,avatar_url) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
	void insert(User user);

	@Select("Select * from user where token = #{token}")
	User fingByToken(@Param("token") String token);
	
	@Select("Select * from user where id = #{id}")
	User findById(@Param("id")Integer id);

	@Select("Select * from user where account_id = #{accountId}")
	User findByAccountId(@Param("accountId") String accountId);

	@Update("update user set name = #{name}, token = #{token}, avatar_url = #{avatarUrl}, gmt_modified = #{gmtModified} where id = #{id}")
	void update(User dbUser);
}
