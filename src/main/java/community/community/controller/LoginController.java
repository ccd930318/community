package community.community.controller;


import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import community.community.mapper.UserAccountMapper;
import community.community.model.UserAccount;
import community.community.model.UserAccountExample;

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
						  HttpServletResponse respone,
						  Model model){
		model.addAttribute(accountId);
		model.addAttribute(password);
		UserAccountExample userAccountExample = new UserAccountExample();
		userAccountExample.createCriteria().andAccountIdEqualTo(accountId);
		List<UserAccount> userAccount = userAccountMapper.selectByExample(userAccountExample);
		
		if((userAccount.get(0).getAccountId().equals(accountId)) && (userAccount.get(0).getPassword().equals(password))) {
			Cookie cookie = new Cookie("accountId",accountId);
			cookie.setMaxAge(1*24*24*60);
			request.getSession().setAttribute("userAccount", userAccount);
			respone.addCookie(cookie);
			return "redirect:/";
		}

		return "login";
		
	}
			
}
