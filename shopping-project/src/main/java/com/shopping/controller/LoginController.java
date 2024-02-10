package com.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.entity.User;
import com.shopping.exception.ActionException;
import com.shopping.repository.UserRepository;

@CrossOrigin("*")
@RestController
public class LoginController {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody User user) throws ActionException {
		System.out.println("Login");
		System.out.println("user :" + user);
		
		User existingUser = userRepository.findByUsername(user.getUsername());
		if (existingUser == null) {
			// 返回登入頁，並提示用戶不存在
			throw new ActionException("用戶不存在", "USER_NOT_FOUND");
		}
		
		if (user.getPassword().equals(existingUser.getPassword())){
			// 登入成功
			return ResponseEntity.ok(existingUser);
		} else {
			throw new ActionException("密碼錯誤", "INVALID_PASSWORD");
		}
	}
	
	@GetMapping("/users")
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping("/user/{username}")
	public User findByUsername(@PathVariable String username) {
		return userRepository.findByUsername(username);
	}

}
