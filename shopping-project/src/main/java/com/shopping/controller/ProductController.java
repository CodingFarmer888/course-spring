package com.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.entity.Product;
import com.shopping.model.ProductInfo;
import com.shopping.service.ProductService;

@CrossOrigin("*")
@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping(value = { "/products/{pageNo}/{pageSize}" })
	public ResponseEntity<Page<ProductInfo>> getProductsByPage(@PathVariable Integer pageNo, @PathVariable Integer pageSize) {
		Page<ProductInfo> page = productService.getProductsPage(pageNo, pageSize);
		return ResponseEntity.ok(page);
	}
	
	@PostMapping("/product")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		Product newProduct = productService.save(product);
		return ResponseEntity.ok(newProduct);
	}
}
