package com.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping("/resiger")
	public String resiger(@RequestParam("username") String username, @RequestParam("password") String password) {
		userService.addUser(username, password);
		return "registerSuccess";
	}
}
