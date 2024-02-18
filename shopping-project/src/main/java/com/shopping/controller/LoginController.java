package com.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.entity.User;
import com.shopping.exception.ActionException;
import com.shopping.model.CartInfo;
import com.shopping.repository.UserRepository;

@CrossOrigin(origins = { "http://localhost:3000" }, allowedHeaders = "*", allowCredentials = "true")
@RestController
public class LoginController {
	
	@Autowired
	private CartInfo cartInSession;
	
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

	@PostMapping("/logout")
	public void logout() {
		// TODO登出，清空Session User資料
	}

}
