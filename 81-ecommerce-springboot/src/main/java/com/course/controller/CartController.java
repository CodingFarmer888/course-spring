package com.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.model.session.CartSession;
import com.course.model.vo.CartVo;
import com.course.service.CartService;

@CrossOrigin(origins = { "http://localhost:3000" }, allowedHeaders = "*", allowCredentials = "true")
@RestController
public class CartController {

	@Autowired
	private CartService cartService;
	
	@PostMapping("/cart/{code}")
	public void addProductToCart(@PathVariable String code) {
		cartService.addProductToCart(code);
	}
	
	@GetMapping("/cart")
	public CartVo getCartInfo() {
		return cartService.getCart();
	}
	
	/**
	 * 從購物車刪除商品
	 * @param code
	 */
	@DeleteMapping("/cart/{code}")
	public CartVo removeProduct(@PathVariable String code) {
		return cartService.removeProductFromCart(code);
	}
	
}
