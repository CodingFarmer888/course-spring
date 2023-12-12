package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.entity.Order;
import com.ecommerce.model.entity.Product;
import com.ecommerce.service.OrderService;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	/**
	 * 針對顧客查詢訂單
	 * @param customerId
	 */
	@PostMapping(value = "/customer")
	public void getCustomerOrders(@RequestParam String customerId) {
		// TODO
		List<Order> orderList = orderService.getOrderByCustomerKey(1L);
		for (Order o : orderList) {
			List<Product> p = o.getProducts();
			System.out.println(p);
		}
	}
}
