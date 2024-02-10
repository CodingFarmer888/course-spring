package com.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.entity.Product;
import com.shopping.model.ProductInfo;
import com.shopping.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping(value = { "/productList" })
	public ResponseEntity<List<ProductInfo>> listProductHandler() {
		productService.getAllProducts();
		return null;
	}
	
	@PostMapping("/product")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		Product newProduct = productService.save(product);
		return ResponseEntity.ok(newProduct);
	}
}
