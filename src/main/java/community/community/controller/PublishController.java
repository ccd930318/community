package community.community.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import community.community.mapper.QuestionMapper;
import community.community.model.Question;
import community.community.model.User;

@Controller
public class PublishController {
	@Autowired
	private QuestionMapper questionMapper;
	
	@GetMapping("/publish")
	public String Publish() {
		return "publish";
	}
	
	@PostMapping("/publish")
	public String doPublish(
		@RequestParam("title") String title,
		@RequestParam("description") String description,
		@RequestParam("tag") String tag,
		HttpServletRequest request,
		Model model) {
		
		model.addAttribute("title",title);
		model.addAttribute("description",description);
		model.addAttribute("tag",tag);
		
		if(title == null || title== "") {
			model.addAttribute("error","標題不能為空");
			return "publish";
		}
		if(description == null || description == "") {
			model.addAttribute("error","內容不能為空");
			return "publish";
		}
		if(tag == null || tag == "") {
			model.addAttribute("error","標籤不能為空");
			return "publish";
		}
		
		User user = (User)request.getSession().getAttribute("user");
		
		if(user == null) {
			model.addAttribute("error","用戶未登入");
			return "publish";
		}
		
		Question question =new Question();
		question.setTitle(title);
		question.setDescription(description);
		question.setTag(tag);
		question.setCreator(user.getId());
		question.setGmtCreate(System.currentTimeMillis());
		question.setGmtModified(question.getGmtCreate());
		
		
		questionMapper.create(question);
		return "redirect:/";
	}
}
