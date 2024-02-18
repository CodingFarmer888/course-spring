package com.shopping.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.entity.Product;
import com.shopping.model.CartInfo;
import com.shopping.model.CartLineInfo;
import com.shopping.model.CustomerForm;
import com.shopping.model.CustomerInfo;
import com.shopping.model.ProductInfo;
import com.shopping.service.ProductService;
import com.shopping.utils.ProductUtils;

// 要能夠讓前端請求取得Session，需要加入allowedHeader跟allowCredentials
@CrossOrigin(origins = { "http://localhost:3000" }, allowedHeaders = "*", allowCredentials = "true")
@RestController
public class CartController {

	@Autowired
	private CartInfo cartInSession;
	
//	@Autowired
//	private CartInfoSession cartInSession;

	@Autowired
	private ProductService productService;
	
	/**
	 * 商品加入購物車
	 * 這裡使用GetMapping是為了要避免Post的Samesite問題，無法取得相同的Session
	 * @param code
	 */
	@PostMapping("/cart/{code}")
	public void addProductToCart(@PathVariable String code) {
		System.out.println("addProductToCart Code: " + code);

		Product product = null;
		if (StringUtils.isNotBlank(code)) {
			product = productService.findProduct(code);
		}
		if (product != null) {
			ProductInfo productInfo = ProductUtils.convertEntityToInfo(product);
			cartInSession.addProduct(productInfo, 1);
		}
	}
	
	/**
	 * 從Session當中取得購物車資料
	 * @return
	 */
	@GetMapping("/shoppingCart")
	public ResponseEntity<List<CartLineInfo>> shoppingCartView() {
		List<CartLineInfo> lineInfos = cartInSession.getCartLines();
		return ResponseEntity.ok(lineInfos);
	}
	
	/**
	 * 從購物車移除商品
	 * @param code
	 * @return
	 */
	@DeleteMapping("/shoppingCartRemoveProduct/{code}")
	public ResponseEntity<List<CartLineInfo>> shoppingCartRemoveProduct(@PathVariable String code) {
		
		Product product = null;
		if (StringUtils.isNotBlank(code)) {
			product = productService.findProduct(code);
		}
		if (product != null) {
			ProductInfo productInfo = new ProductInfo(product);
			cartInSession.removeProduct(productInfo);
		}
		List<CartLineInfo> cartLineInfos = cartInSession.getCartLines();
		return ResponseEntity.ok(cartLineInfos);
	}
	
	@PostMapping("/checkout")
	public ResponseEntity<CartInfo> checkout(@RequestBody CustomerForm customerForm) {
	      CustomerInfo customerInfo = new CustomerInfo(customerForm);
	      cartInSession.setCustomerInfo(customerInfo);
	      CartInfo cartInfo = new CartInfo();
	      cartInfo.setCustomerInfo(customerInfo);
	      
	      for (CartLineInfo lineInfo : cartInSession.getCartLines()) {
	    	  cartInfo.addProduct(lineInfo.getProductInfo(), lineInfo.getQuantity());
	      }

	      return ResponseEntity.ok(cartInfo);

	}
}
