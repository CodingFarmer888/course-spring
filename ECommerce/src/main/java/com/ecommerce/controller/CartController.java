package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.error.ActionException;
import com.ecommerce.model.vo.Cart;
import com.ecommerce.service.CartService;

@RestController
@RequestMapping(value = "/cart")
public class CartController {

	@Autowired
	private Cart cartInSession;
	
	@Autowired
	private CartService cartService;	
	
	/** 商品加入購物車 */ // TODO: 這個可以當回家練習
	@GetMapping(value = "/addToCart/{productId}/{qty}")
	public ResponseEntity<Cart> addProductToCart(@PathVariable String productId, @PathVariable Integer qty) {
		Cart cart = cartService.addToCart(productId, qty);
		return ResponseEntity.ok(cart);
	}
	
	/** 查看購物車內容 */
	@GetMapping(value = "/all")
	public ResponseEntity<Cart> getCart() {
		Cart cart = new Cart();
		// Session中的物件，不能直接序列化往前端傳遞
		cart.setProductLineItemList(cartInSession.getProductLineItemList());
		return ResponseEntity.ok(cart);
	}
	
	/**
	 * 結帳，將購物車轉換為Order
	 * @throws ActionException 
	 */
	@PostMapping(value = "/checkout")
	public void checkOut(@RequestParam String customerId) throws ActionException {
		cartService.checkOut(customerId);
	}

}
