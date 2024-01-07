package springMvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import springMvc.entity.UserEntity;
import springMvc.service.UserService;
import springMvc.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String loginView() {
		return "login";
	}
	
	@GetMapping("/register")
	public String registerView() {
		return "register";
	}
	@GetMapping("/modify")
	public String modifyUserView() {
		return "modifyUser";
	}
	
	@GetMapping("/all")
	public ModelAndView findAllUser() {
		List<UserEntity> userList = userService.findAllUser();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("userList");
		mav.addObject("users", userList);
		return mav;
	}
	
	@PostMapping("/doLogin")
	public ModelAndView doLogin(String email, String password) {
		UserEntity user = userService.findUser(email, password);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("loginSuccess");
		mav.addObject("user", user);
		return mav;
	}
	
	@PostMapping("/add")
	public String addUser(@ModelAttribute UserVo userVo) {
		boolean isAddSuccess = userService.addUser(userVo);
		if (isAddSuccess) {
			return "addUserSuccess";
		} else {
			return "addUserError";
		}
	}
	
	@PostMapping("/update")
	public String updateUser(@ModelAttribute UserVo userVo) {
		userService.updateUser(userVo);
		return "addUserSuccess";
	}
	

	
	@PostMapping("/doLoginAndSaveSession")
	public ModelAndView doLogin(String email, String password, HttpSession session) {
		UserEntity user = userService.findUser(email, password);
		session.setAttribute("user", user);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("loginSuccess");
		mav.addObject("user", user);
		return mav;
	}
}
