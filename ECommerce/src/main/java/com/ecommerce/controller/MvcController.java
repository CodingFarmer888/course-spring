package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.model.vo.Cart;

@RestController
@RequestMapping(value = "/mvc")
public class MvcController {

	@Autowired
	private Cart cartInSession;
	
	/** 查看購物車內容 */
	@GetMapping(value = "/show/cart")
	public ModelAndView getCart() {
		ModelAndView mav = new ModelAndView("/showCart");
		Cart cart = new Cart();
		// Session中的物件，不能直接序列化往前端傳遞
		cart.setProductLineItemList(cartInSession.getProductLineItemList());
		mav.addObject("cart", cart);
		mav.addObject("productLineItems", cart.getProductLineItemList());
		mav.addObject("totalAmount", cart.getTotalAmount());
		
		return mav;
	}
}
