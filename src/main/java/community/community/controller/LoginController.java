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
		UserAccount userAccount = new UserAccount();
		userAccount =userAccountMapper.findByAccountId(accountId);
		
		if(userAccount.getAccountId().equals(accountId) && userAccount.getPassword().equals(password)) {
			request.getSession().setAttribute("userAccount", userAccount);
			return "redirect:/";
		}

		return "login";
		
	}
			
}
