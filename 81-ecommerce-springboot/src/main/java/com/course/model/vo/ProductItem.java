package com.course.model.vo;

import java.math.BigDecimal;

public class ProductItem {

	/** 商品 */
	private ProductVo product;
	
	/** 商品數量 */
	private Integer quantity;
	
	/** 金額小計 */
	private BigDecimal totalAmount;

	public ProductItem(ProductVo product, Integer quantity, BigDecimal totalAmount) {
		this.product = product;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
	}

	public ProductVo getProduct() {
		return product;
	}

	public void setProduct(ProductVo product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

}
