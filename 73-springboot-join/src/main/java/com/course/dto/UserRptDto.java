package com.course.dto;

public class UserRptDto {

	private Long userId;
	
	private String userName;
	
	private Long orderId;
	
	private String productName;
	
	private Integer productPrice;
	
	public UserRptDto() {

	}

	public UserRptDto(Long userId, String userName, Long orderId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.orderId = orderId;
	}

	public UserRptDto(Long userId, String userName, Long orderId, String productName, Integer productPrice) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.orderId = orderId;
		this.productName = productName;
		this.productPrice = productPrice;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}
	
	
}
