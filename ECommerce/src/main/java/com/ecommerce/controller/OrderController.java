package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.dto.OrderDto;
import com.ecommerce.service.OrderService;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

	@Autowired
	OrderService orderService;

	@PostMapping(value = "/search")
	public OrderDto searchOrders(@RequestParam String customerId, @RequestParam String startDate,
			@RequestParam String endDate) {

		orderService.xxx(customerId, startDate, endDate);
		return null;
	}

}
