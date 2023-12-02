package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.CustomerEntity;
import com.ecommerce.entity.ProductEntity;
import com.ecommerce.service.CustomerService;
import com.ecommerce.service.ProductService;

@RestController
public class TestController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(value = "/customer/{id}")
	public void findCustomer(@PathVariable("id") String customerId) {
		CustomerEntity cu = customerService.findCustomerById(customerId);
		System.out.println(cu);
	}
	
	@GetMapping(value = "/products")
	public ResponseEntity<List<ProductEntity>> xxx() {
		List<ProductEntity> productList = productService.getAllProducts();
		for (ProductEntity product : productList) {
			System.out.println(product.getProductId());
		}
		return ResponseEntity.ok(productList);
		
	}

}
