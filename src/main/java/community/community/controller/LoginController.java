package community.community.controller;

import javax.servlet.http.Cookie;
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
public class LoginController {
	@Autowired
	private UserAccountMapper userAccountMapper;
	
	@GetMapping("/login")
	public String Login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String doLogin(@RequestParam("accountId") String accountId,
						  @RequestParam("password") String password,
						  HttpServletRequest request,
						  Model model){
		model.addAttribute(accountId);
		model.addAttribute(password);
		UserAccount userAccount =userAccountMapper.findByAccountId(accountId);
		if(userAccount == null) {
			return "login";
		}
		
		if(userAccount.getAccountId() != accountId && userAccount.getPassword() != password) {
			return "login";
		}
		new Cookie("accountId",accountId);
		request.getSession().setAttribute("userAccount", userAccount);
		
		return "redirect:/";
	}
			
}
