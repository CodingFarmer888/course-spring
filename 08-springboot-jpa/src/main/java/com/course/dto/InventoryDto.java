package com.course.dto;

public class InventoryDto {

	/** 商品名稱 */
	private String productName;
	
	/** 門店名稱 */
	private String storeName;
	
	/** 數量 */
	private Integer quantity;
	
	public InventoryDto() {

	}

	public InventoryDto(String productName, String storeName, Integer quantity) {
		this.productName = productName;
		this.storeName = storeName;
		this.quantity = quantity;
	}


	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
