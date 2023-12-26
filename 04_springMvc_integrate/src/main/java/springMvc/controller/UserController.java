package springMvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import springMvc.entity.UserEntity;
import springMvc.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String loginView() {
		return "login";
	}
	
	@PostMapping("/doLogin")
	public ModelAndView findUser(String username, String password) {
		UserEntity user = userService.findUser(username, password);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("userTest");
		mav.addObject("user", user);
		return mav;
	}
	
	@PostMapping("/add")
	public String addUser(String username, String password) {
		userService.addUser(username, password);
		return "addUserSuccess";
	}
}
