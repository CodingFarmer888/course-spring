package com.course.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityResult;
import jakarta.persistence.FieldResult;
import jakarta.persistence.Id;
import jakarta.persistence.SqlResultSetMapping;

@SqlResultSetMapping(
name = "UserCustomRptDtoMapping",
entities={
  @EntityResult(
      entityClass = com.course.dto.UserCustomRptDto.class,
      fields = {
    	// name為UserCustomRptDto這個Entity的欄位
    	// column 為SQL的欄位名稱，這裡使用可以使用別名來對應
      	@FieldResult(name="userId", column="USERID"),
        @FieldResult(name="userName",  column="USERNAME"),
        @FieldResult(name="orderId",  column="ORDERID"),
        @FieldResult(name="productName",  column="PRODUCTNAME"),
        @FieldResult(name="productPrice",  column="PRODUCTPRICE")
      }
  )
})

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
