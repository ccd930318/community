package community.community.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import community.community.dto.QuestionDTO;
import community.community.mapper.QuestionMapper;
import community.community.model.Question;
import community.community.model.User;
import community.community.model.UserAccount;
import community.community.service.QuestionService;

@Controller
public class PublishController {
	
	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/publish/{id}")
	public String edit(@PathVariable(name = "id")Integer id,
						Model model) {
		QuestionDTO question = questionService.getById(id);
		model.addAttribute("title",question.getTitle());
		model.addAttribute("description",question.getDescription());
		model.addAttribute("tag",question.getTag());
		model.addAttribute("id",question.getId());
		return "publish";
	}
	
	@GetMapping("/publish")
	public String Publish() {
		return "publish";
	}
	
	@PostMapping("/publish")
	public String doPublish(
		@RequestParam(value = "title",required = false) String title,
		@RequestParam(value = "description",required = false) String description,
		@RequestParam(value = "tag",required = false) String tag,
		@RequestParam(value = "id",required = false) Integer id,
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
		
		UserAccount user = (UserAccount)request.getSession().getAttribute("userAccount");
		
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
		question.setId(id);
		
		questionService.createOrUpdate(question);

		return "redirect:/";
	}
}
