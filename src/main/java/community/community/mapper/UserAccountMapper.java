package community.community.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import community.community.model.UserAccount;

@Mapper
public interface UserAccountMapper {
	@Insert("insert into user_account (account_id,name,password,email,sex,gmt_create,gmt_modified) values (#{accountId},#{name},#{password},#{email},#{sex},#{gmtCreate},#{gmtModified})")
	void insert(UserAccount user);

	@Select("Select * from user_account where email = #{email}")
	UserAccount fingByEmail(@Param("email") String token);
	
	@Select("Select * from user_account where id = #{id}")
	UserAccount findById(@Param("id")Integer id);

	@Select("Select * from user_account where account_id = #{accountId}")
	UserAccount findByAccountId(@Param("accountId") String accountId);

	@Update("update user set account_id = #{accountId}, password = #{password}, name = #{name}, gmt_modified = #{gmtModified} where id = #{id}")
	void update(UserAccount dbUser);
}


