package com.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.course.dao.UserJpaDao;
import com.course.dao.impl.UserCustomDao;
import com.course.dto.UserRptDto;
import com.course.service.UserService;

@RestController
public class JoinController {
	// 為簡化範例，直接從Controller呼叫Dao，正規流程請務必透由Service層呼叫Dao

	@Autowired
	private UserJpaDao userDao;
	
	@Autowired
	private UserCustomDao userCustomDao;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/jpql/user/orders/{userId}")
	public List<UserRptDto> findUserOrders(@PathVariable Long userId) {
		return userService.findOrdersByUserId(userId);
	}
	
	@GetMapping("/jpql/user/orderitems/{userId}")
	public List<UserRptDto> findUserOrderItems(@PathVariable Long userId) {
		return userDao.findUserOrdersProducts(userId);
	}
	
	@GetMapping("/entityManager/orderItems/{userId}")
	public List<UserRptDto> getOrderItemByUserId(@PathVariable Long userId) {
		return userCustomDao.getOrderDetailByUserId(userId);
	}
	
	@GetMapping("/entityManager/getOrderItemByCondition/")
	public List<UserRptDto> getOrderItemByCondition(@RequestParam Long userId, @RequestParam(required = false) Integer price) {
		return userCustomDao.getOrderDetailByCondition(userId, price);
	}
	
}
