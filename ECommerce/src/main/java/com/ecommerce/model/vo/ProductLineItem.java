package com.ecommerce.model.vo;

import com.ecommerce.model.dto.ProductDto;

public class ProductLineItem {

	/** 商品 */
	private ProductDto productDto = new ProductDto();
	
	private ProductItem productItem = new ProductItem();
	
	/** 購買數量 */
	private Integer qty = 0;

	public ProductItem getProductItem() {
		return productItem;
	}

	public void setProductItem(ProductItem productItem) {
		this.productItem = productItem;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public ProductDto getProductDto() {
		return productDto;
	}

	public void setProductDto(ProductDto productDto) {
		this.productDto = productDto;
	}

}
