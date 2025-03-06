package com.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.course.dao.service.UserService;
import com.course.entity.User;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
		// UserService userService = new UserService();
		// 檢查帳號是否存在
		User user = userService.checkUser(username, password);

		if (user != null) {
			return "loginSuccess";
		} else {
			return "loginError";
		}
	}
	
	@RequestMapping("/register")
	public String register(@RequestParam("username") String username, @RequestParam("password") String password) {
		userService.addUser(username, password);
		return "registerSuccess";
	}
	
	@RequestMapping("/userList")
	public ModelAndView allUsers() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("userList");
		mv.addObject("users", userService.getAllUsers());
		return mv;
	}
	
	@RequestMapping("/deleteUser")
	public ModelAndView deleteUser(String username) {
		// 刪除使用者
		userService.deleteUser(username);
		
		// 轉導回使用者列表頁
		ModelAndView mv = new ModelAndView();
		mv.setViewName("userList");
		mv.addObject("users", userService.getAllUsers());
		return mv;
	}
	
	@RequestMapping("/updateUser")
	public ModelAndView updateUser(String username, String password) {
		// 更新使用者
		userService.updateUser(username, password);
		
		// 轉導回使用者列表頁
		ModelAndView mv = new ModelAndView();
		mv.setViewName("userList");
		mv.addObject("users", userService.getAllUsers());
		return mv;
	}
}
