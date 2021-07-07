package community.community.dto;

import lombok.Data;

@Data
public class LoginUser {
	private String accountId;
	private String password;
	private String aamuuid;
}
