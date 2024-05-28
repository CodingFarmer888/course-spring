package com.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.entity.Product;
import com.course.service.ProductService;

@CrossOrigin(value = "http://localhost:3000")
@RestController
public class BakeryController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping("/add")
	public String addProduct(String name, String descript, String img, Integer price, String category) {
		service.addProduct(name, descript, img, price, category);
		return "add";
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProduct() {
		List<Product> productList = service.findAllProduct();
		return ResponseEntity.ok(productList);
	}
	
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
		Product product = service.findById(id);
		return ResponseEntity.ok(product);
		
	}
	
	@PutMapping("/update")
	public String addProduct(Long id, String name, String descript, String img, Integer price, String category) {
		service.update(id, name, descript, img, price, category);
		return "update";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable Long id) {
		service.deleteById(id);
		return "delete";
	}

}
