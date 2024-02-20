package com.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.course.dto.UserRptDto;
import com.course.repository.UserRepository;

@RestController
public class JoinController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/user/orders/{userId}")
	public List<UserRptDto> findUserOrders(@PathVariable Long userId) {
		return userRepository.findUserOrders(userId);
	}
	
	@GetMapping("user/orderitems/{userId}")
	public List<UserRptDto> findUserOrderItems(@PathVariable Long userId) {
		return userRepository.findUserOrdersProducts(userId);
	}
	
}
