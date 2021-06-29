package community.community.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import community.community.dto.AccessTokenDTO;
import community.community.dto.GithubUser;
import community.community.mapper.UserMapper;
import community.community.model.User;
import community.community.provider.GithubProvider;

@Controller
public class AuthorizeController {
	
	
	@Autowired
	private GithubProvider githubProvider;
	
	@Value("{$github.client.id}")
	private String clientId;
	@Value("{$github.client.secret")
	private String clientSecret;
	@Value("{$github.redirect.uri}")
	private String redirectUri;
	
	@Autowired
	private UserMapper userMapper;
	
	@GetMapping("/callback")
	public String callback(@RequestParam(name="code") String code,HttpServletRequest request){
		AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
		accessTokenDTO.setClient_id(clientId);
		accessTokenDTO.setClient_secret(clientSecret);
		accessTokenDTO.setCode(code);
		accessTokenDTO.setRedirect_uri(redirectUri);

		String accessToken = githubProvider.getAccessToken(accessTokenDTO);
		GithubUser githubUser = githubProvider.getUser(accessToken);
		if(githubUser != null) {
			User user = new User();
			userMapper.insert(user);
			user.setToken(UUID.randomUUID().toString());
			user.setName(githubUser.getName());
			user.setAccountId(String.valueOf(githubUser.getId()));
			user.setGmtCreate(System.currentTimeMillis());
			user.setGmtModified(user.getGmtCreate());
			request.getSession().setAttribute("user", githubUser);
			return "redirect:/";
		}else {
			return "redirect:index";
		}
	}
}