package community.community.model;

import lombok.Data;

@Data
public class UserAccount {
	private Integer id;
	private String name;
	private String accountId;
	private String password;
	private String email;
	private String sex;
	private Long gmtCreate;
	private Long gmtModified;
	private String avatarUrl;
}
