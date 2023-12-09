package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.ProductDao;
import com.ecommerce.model.dto.ProductDto;
import com.ecommerce.model.vo.Cart;
import com.ecommerce.model.vo.ProductLineItem;

@Service
public class CartService {
	
	@Autowired
	private Cart cartInSession;
	
	@Autowired
	private ProductService productService;
	
	/**
	 * 商品加入購物車
	 * TODO: 業務邏輯回家作業
	 */
	public Cart addToCart(String productId, Integer qty) {

		// 取得Session中的購物車物件
		List<ProductLineItem> itemList = cartInSession.getProductLineItemList();
		// 判斷本次所加的商品是否已經存在購物車當中
		ProductLineItem productLineItem = itemList.stream().filter(item -> item.getProductItem().getProductId().equals(productId)).findFirst().orElse(null);
		if (productLineItem != null) {
			// 商品已經存在購物車，直接加數量
			productLineItem.setQty(productLineItem.getQty() + qty);
		} else {
			// 本次新增商品，從DB取得商品資料
			ProductDto dto = productService.getProductById(productId);
			ProductLineItem lineItem = new ProductLineItem();
			lineItem.setProductDto(dto);
			lineItem.setQty(qty);
			cartInSession.getProductLineItemList().add(lineItem);
		}
		
		// TODO: 計算購物車金額
		
		// 因為不能在session的購物車不能直接往前端送，需要重新assign
		Cart cart = new Cart();
		cart.setProductLineItemList(cartInSession.getProductLineItemList());
		
		return cart; 
	}
	
}
