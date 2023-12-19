package com.ecommerce.model.dto;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityResult;
import jakarta.persistence.FieldResult;
import jakarta.persistence.Id;
import jakarta.persistence.SqlResultSetMapping;

@SqlResultSetMapping(
name = "OrderProductDtoMapping",
entities={
  @EntityResult(
      entityClass = com.ecommerce.model.dto.OrderProductDto.class,
      fields = {
      	@FieldResult(name="orderProductKey", column="ORDERPRODUCTKEY"),
        @FieldResult(name="orderKey",  column="ORDERKEY"),
        @FieldResult(name="customerName",  column="CUSTOMERNAME"),
        @FieldResult(name="productName",  column="PRODUCTNAME"),
        @FieldResult(name="productQty",  column="PRODUCTQTY"),
        @FieldResult(name="totalAmount",  column="TOTALAMOUNT"),
      	@FieldResult(name="orderDate",  column="ORDERDATE")
      }
  )
}
)
// Mapping 需要Entity
@Entity
public class OrderProductDto {
	//
	@Id
	private Long orderProductKey;
	
	/** 訂單鍵值 */
	private Long orderKey;
	
	/** 顧客名稱 */
	private String customerName;
	
	/** 商品名稱 */
	private String productName;
	
	/** 商品數量 */
	private Integer productQty;
	
	/** 訂單金額 */
	private BigDecimal totalAmount;
	
	/** 訂單日期 */
	private Date orderDate;
	
	public OrderProductDto() {
		
	}

	public Long getOrderKey() {
		return orderKey;
	}

	public void setOrderKey(Long orderKey) {
		this.orderKey = orderKey;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Long getOrderProductKey() {
		return orderProductKey;
	}

	public void setOrderProductKey(Long orderProductKey) {
		this.orderProductKey = orderProductKey;
	}

	public Integer getProductQty() {
		return productQty;
	}

	public void setProductQty(Integer productQty) {
		this.productQty = productQty;
	}
	
}
