package community.community.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import community.community.mapper.UserAccountMapper;
import community.community.model.UserAccount;

@Controller
public class SigninController {
	@Autowired
	private UserAccountMapper userAccountMapper;
	
	@GetMapping("/signin")
	public String Signin() {
		return "signin";
	}
	
	@PostMapping("/signin")
	public String doSignin(
		@RequestParam("accountId") String accountId,
		@RequestParam("password") String password,
		@RequestParam("repassword") String repassword,
		@RequestParam("name") String name,
		@RequestParam("email") String email,
		@RequestParam("sex") String sex,
		@RequestParam("avatarUrl") String avatarUrl,
		HttpServletRequest request,
		Model model) {
		
		model.addAttribute("accountId",accountId);
		model.addAttribute("password",password);
		model.addAttribute("repassword",repassword);
		model.addAttribute("name",name);
		model.addAttribute("email",email);
		model.addAttribute("sex",sex);
		model.addAttribute("avatarUrl",avatarUrl);
		
//		if(repassword != password) {
//			model.addAttribute("error","密碼不一致");
//			return "signin";
//		}
		
		UserAccount user1 = (UserAccount)request.getSession().getAttribute("userAccount");
		
		if(user1 != null) {
			return "index";
		}
		
		UserAccount user = new UserAccount();
			user.setAccountId(accountId);
			user.setPassword(password);
			user.setName(name);
			user.setEmail(email);
			user.setSex(sex);
			user.setGmtCreate(System.currentTimeMillis());
			user.setGmtModified(user.getGmtCreate());
			user.setAvatarUrl(avatarUrl);
		
			userAccountMapper.insert(user);
			request.getSession().setAttribute("userAccount",user);
			return "redirect:/login";
	}
}
