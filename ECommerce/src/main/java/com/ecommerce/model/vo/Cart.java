package com.ecommerce.model.vo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 購物車Session物件
 */
public class Cart {

	/** 商品 */
	private List<ProductLineItem> productLineItemList = new ArrayList<>();
	
	/** 總金額 */
	private BigDecimal totalAmount = new BigDecimal("100");

	public List<ProductLineItem> getProductLineItemList() {
		return productLineItemList;
	}

	public void setProductLineItemList(List<ProductLineItem> productLineItemList) {
		this.productLineItemList = productLineItemList;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	
}
