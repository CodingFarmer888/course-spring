package com.ecommerce.model.vo;

import java.math.BigDecimal;

public class ProductItem {
	
	/** 商品ID */
	private String productId;
	
	/** 商品名稱 */
	private String name;
	
	/** 品牌 */
	private String brand;
	
	/** 定價 */
	private BigDecimal listPrice;
	
	/** 定價呈現 */
	private String listPriceDisp;
	
	/** 售價 */
	private BigDecimal salesPrice;
	
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

	public BigDecimal getListPrice() {
		return listPrice;
	}

	public void setListPrice(BigDecimal listPrice) {
		this.listPrice = listPrice;
	}

	public String getListPriceDisp() {
		return listPriceDisp;
	}

	public void setListPriceDisp(String listPriceDisp) {
		this.listPriceDisp = listPriceDisp;
	}

	public BigDecimal getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(BigDecimal salesPrice) {
		this.salesPrice = salesPrice;
	}

	public String getSalesPriceDisp() {
		return salesPriceDisp;
	}

	public void setSalesPriceDisp(String salesPriceDisp) {
		this.salesPriceDisp = salesPriceDisp;
	}
	
}
