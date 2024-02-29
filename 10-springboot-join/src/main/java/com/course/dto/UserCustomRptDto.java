package com.course.dto;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SqlResultSetMapping;

@SqlResultSetMapping(name = "UserCustomRptDtoMapping", classes = {
		@ConstructorResult(targetClass = com.course.dto.UserCustomRptDto.class, columns = {
				@ColumnResult(name = "USERID", type = Long.class),
				@ColumnResult(name = "USERNAME", type = String.class),
				@ColumnResult(name = "ORDERID", type = Long.class),
				@ColumnResult(name = "PRODUCTNAME", type = String.class),
				@ColumnResult(name = "PRODUCTPRICE", type = Integer.class) }) })

// 這裡的Entity不是真實存在於資料當中的實體，而是為了映射結果集產生的對應實體
@Entity
public class UserCustomRptDto {
	// Entity必須有Id
	@Id
	private Long userId;

	private String userName;

	private Long orderId;

	private String productName;

	private Integer productPrice;

	// 預設建構式
	public UserCustomRptDto() {

	}

	// 帶有欄位的建構式，提供Ｍapping使用
	public UserCustomRptDto(Long userId, String userName, Long orderId, String productName, Integer productPrice) {
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
