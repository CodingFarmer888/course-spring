package com.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.repository.UserRepository;

@RestController
public class LoginController {
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/login")
	public void login() {
		System.out.println("Login");
	}

}
