package com.course.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.course.model.User;
import com.course.service.UserService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@CrossOrigin(origins ={"http://127.0.0.1:5500"}, allowedHeaders = "*", allowCredentials = "true")
public class HelloRestController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String hello() {
		return "hello";
	}
	
	@Operation(summary = "取得使用者", description = "詳細描述", tags = { "我是標籤", "我是標籤2" })
	@GetMapping("/user")
	public User user() {
		User user = new User();
		user.setName("凱蒂貓");
		user.setAge(5);
		user.setHobbies(Arrays.asList("吃飯", "睡覺", "打東東"));
		return user;
	}


	@Operation(summary = "取得所有使用者", description = "取得所有使用者", tags = "Annotation 介紹")
	@GetMapping("/users")
	// @CrossOrigin(origins = "http://127.0.0.1:5500", methods = {RequestMethod.GET})
	public List<User> getAllUsers() {
		return userService.queryAllUsers();
	}
	
	@Operation(summary = "新增使用者: RequestBody", description = "新增使用者", tags = "Annotation 介紹")
	@PostMapping("/user")
	public User addUser(@RequestBody User user) {
		return user;
	}
	
	@Operation(summary = "修改使用者", description = "修改使用者", tags = "Annotation 介紹")
	@PutMapping("/user")
	public User updateUser(User user) {
		return user;
	}
	
	@Operation(summary = "刪除使用者", description = "刪除使用者", tags = "Annotation 介紹")
	@DeleteMapping("/user")
	public User deleteUser(User user) {
		return user;
	}
	
	@Operation(summary = "透過名稱取得使用者: PathVariable", description = "透過名稱得使用者", tags = "Annotation 介紹")
	@GetMapping("/user/name/{name}")
	public User getUserByName(@PathVariable String name) {
		List<User> users = userService.queryAllUsers();
		User user = users.stream().filter(u -> name.equals(u.getName())).findFirst().orElse(null);
		return user;
	}
	
	@Operation(summary = "更新使用者: @RequestParam", description = "更新使用者", tags = "Annotation 介紹")
	@PutMapping("/user/age")
	public User updateUserAge(@RequestParam String name, @RequestParam Integer age) {
		User user = new User();
		user.setName(name);
		user.setAge(age);
		user.setHobbies(Arrays.asList("吃飯", "睡覺", "打東東"));
		return user;
	}
	
	@Operation(summary = "透過ID 取得User: ResponseEntity", description = "透過ID 取得User", tags = "Annotation 介紹")
	@GetMapping("/user/id/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
	    User user = userService.findUserById(id);
	    if (user == null) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	    }
	    return ResponseEntity.ok(user);
	}
}
