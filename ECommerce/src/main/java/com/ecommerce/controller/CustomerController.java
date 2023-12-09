package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.entity.Customer;
import com.ecommerce.model.entity.Order;
import com.ecommerce.service.CustomerService;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping(value = "/login")
	public ResponseEntity<Customer> login(@RequestParam String customerId, @RequestParam String password) {
		Customer customer = customerService.login(customerId, password);
		return ResponseEntity.ok(customer);
	}
	
	@GetMapping(value = "/logout")
	public ResponseEntity<String> login() {
		customerService.logout();
		return ResponseEntity.ok("");
	}
	
	@GetMapping(value = "/checkLogin")
	public ResponseEntity<Boolean> checkLogin(@RequestParam String customerId) {
		boolean isLogin = customerService.checkLogin(customerId);
		return ResponseEntity.ok(isLogin);
	}
	
	/**
	 * 查詢顧客訂單
	 */
	@GetMapping(value = "/orders")
	public void getOrdersByCustomer(@RequestParam String customerId) {
		Customer customer = customerService.findCustomerById(customerId);
		List<Order> orders = customer.getOrderList();
		System.out.println(orders);
	}
	
}
