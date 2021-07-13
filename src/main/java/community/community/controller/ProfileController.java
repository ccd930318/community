package community.community.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import community.community.dto.PaginationDTO;
import community.community.model.UserAccount;
import community.community.service.NotificationService;
import community.community.service.QuestionService;

@Controller
public class ProfileController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private NotificationService notificationService;
	
	@GetMapping("/profile/{action}")
	public String profile(HttpServletRequest request,
			@PathVariable(name="action") String action,
			Model model,
			@RequestParam(name = "page",defaultValue = "1") Integer page,
			@RequestParam(name = "size",defaultValue = "5") Integer size) {
		UserAccount user = (UserAccount)request.getSession().getAttribute("userAccount");
		if(user == null) {
			return "redirect:/";
		}
		
		if("questions".equals(action)) {
			model.addAttribute("section","questions");
			model.addAttribute("sectionName","我的文章");
			PaginationDTO paginationDTO = questionService.list(user.getId(), page, size);
			model.addAttribute("pagination",paginationDTO);
			
		}else if("replies".equals(action)){
			PaginationDTO paginationDTO = notificationService.list(user.getId(), page, size);
			Long unreadCount = notificationService.unreadCount(user.getId());
			model.addAttribute("section","replies");
			model.addAttribute("pagination",paginationDTO);	
			model.addAttribute("sectionName","最新回覆");

		}
		
		return "profile";
	}
}
