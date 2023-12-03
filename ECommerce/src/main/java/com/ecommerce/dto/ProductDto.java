package com.ecommerce.dto;

public class ProductDto {

	/** 商品ID */
	private String productId;
	
	/** 商品名稱 */
	private String name;
	
	/** 品牌 */
	private String brand;
	
	/** 商品狀態(上下架) */
	private String statusDisp;
	
	/** 定價呈現 */
	private String listPriceDisp;
	
	/** 售價呈現 */
	private String salesPriceDisp;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getStatusDisp() {
		return statusDisp;
	}

	public void setStatusDisp(String statusDisp) {
		this.statusDisp = statusDisp;
	}

	public String getListPriceDisp() {
		return listPriceDisp;
	}

	public void setListPriceDisp(String listPriceDisp) {
		this.listPriceDisp = listPriceDisp;
	}

	public String getSalesPriceDisp() {
		return salesPriceDisp;
	}

	public void setSalesPriceDisp(String salesPriceDisp) {
		this.salesPriceDisp = salesPriceDisp;
	}
	
}
