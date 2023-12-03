package com.ecommerce.dto;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

public class ProductDto {

	/** 商品ID */
	private String productId;
	
	/** 商品名稱 */
	private String name;
	
	/** 品牌 */
	private String brand;
	
	/** 商品狀態(上下架) */
	private Integer status;
	
	/** 商品狀態(上下架) */
	private String statusDisp;
	
	/** 定價 */
	private BigDecimal listPrice;
	
	/** 定價呈現 */
	private String listPriceDisp;
	
	/** 售價 */
	private BigDecimal salesPrice;
	
	/** 售價呈現 */
	private String salesPriceDisp;
	
	/** 圖檔名稱 */
	private String imgName;
	
	/** 圖檔 */
	private MultipartFile imgFile;

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

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public BigDecimal getListPrice() {
		return listPrice;
	}

	public void setListPrice(BigDecimal listPrice) {
		this.listPrice = listPrice;
	}

	public BigDecimal getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(BigDecimal salesPrice) {
		this.salesPrice = salesPrice;
	}

	public MultipartFile getImgFile() {
		return imgFile;
	}

	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
	}
	
}
