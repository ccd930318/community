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
		HttpServletRequest request,
		Model model) {
		
		model.addAttribute("accountId",accountId);
		model.addAttribute("password",password);
		model.addAttribute("repassword",repassword);
		model.addAttribute("name",name);
		model.addAttribute("email",email);
		model.addAttribute("sex",sex);
		
		if(repassword == "" || repassword != password) {
			model.addAttribute("error","密碼不一致");
			return "signin";
		}
		
		UserAccount user = (UserAccount)request.getSession().getAttribute("user");
		
		if(user == null) {
			return "redirect:/";
		}
		
			user.setAccountId(accountId);
			user.setPassword(password);
			user.setEmail(email);
			user.setSex(sex);
			user.setGmtCreate(System.currentTimeMillis());
			user.setGmtModified(user.getGmtCreate());
		
		userAccountMapper.insert(user);
		return "redirect:/";
	}
}
