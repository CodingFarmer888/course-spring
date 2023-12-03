package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dto.ProductDto;
import com.ecommerce.entity.Customer;
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
		Customer customer = customerService.findCustomerById(customerId);
		System.out.println(customer);
	}
	
	@GetMapping(value = "/products")
	public ResponseEntity<List<ProductDto>> xxx() {
		List<ProductDto> productDtoList = productService.getAllProducts();
		return ResponseEntity.ok(productDtoList);
		
	}
	
	@PostMapping(value = "/addProduct")
	public ResponseEntity<String> addProduct(@RequestBody ProductDto dto) {
		productService.addProduct(dto);
		return ResponseEntity.ok("新增商品成功");
	}

}
