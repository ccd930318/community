package community.community.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import community.community.dto.AccessTokenDTO;
import community.community.dto.GithubUser;
import community.community.model.User;
import community.community.provider.GithubProvider;
import community.community.service.UserService;
import okhttp3.Response;

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
	private UserService userService;
	
	@GetMapping("/callback")
	public String callback(@RequestParam(name="code") String code,HttpServletRequest request,HttpServletResponse response){
		AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
		accessTokenDTO.setClient_id(clientId);
		accessTokenDTO.setClient_secret(clientSecret);
		accessTokenDTO.setCode(code);
		accessTokenDTO.setRedirect_uri(redirectUri);

		String accessToken = githubProvider.getAccessToken(accessTokenDTO);
		GithubUser githubUser = githubProvider.getUser(accessToken);
//		if(githubUser != null && githubUser.getId() != null) {
		if(githubUser != null) {
			User user = new User();
			String token = UUID.randomUUID().toString();
			user.setToken(token);
			user.setName(githubUser.getName());
			user.setAccountId(String.valueOf(githubUser.getId()));
			user.setAvatarUrl(githubUser.getAvatarUrl());
			userService.createOrUpdate(user);
			response.addCookie(new Cookie("token",token));
			
			
			request.getSession().setAttribute("user", githubUser);
			return "redirect:/";
		}else {
			return "redirect:index";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request,
						 HttpServletResponse response) {
		request.getSession().removeAttribute("user");
		Cookie cookie =new Cookie("token",null);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		return "redirect:/";
	}
}
