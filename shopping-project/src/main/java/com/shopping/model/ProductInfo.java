package com.shopping.model;

import com.shopping.entity.Product;

public class ProductInfo {
	
	/** 商品編號 */
	private String code;
	
	/** 商品名稱 */
	private String name;
	
	/** 單價 */
	private double price;
	
	/** 圖檔連結 */
	private String imageUrl;

	public ProductInfo() {
	}

	public ProductInfo(Product product) {
		this.code = product.getCode();
		this.name = product.getName();
		this.price = product.getPrice();
		this.imageUrl = product.getImageUrl();
	}

	public ProductInfo(String code, String name, double price, String imageUrl) {
		this.code = code;
		this.name = name;
		this.price = price;
		this.imageUrl = imageUrl;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "ProductInfo [code=" + code + ", name=" + name + ", price=" + price + ", imageUrl=" + imageUrl + "]";
	}
}
