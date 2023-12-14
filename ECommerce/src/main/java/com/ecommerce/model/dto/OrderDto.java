package com.ecommerce.model.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.ecommerce.model.vo.ProductLineItem;

public class OrderDto {

	/** 顧客資料 */
	private CustomerDto customer;

	/**訂單總金額 */
	private BigDecimal totalAmount;
	
	/** 訂單時間 */
	private Date orderDate;

	/** 商品資訊 */
	private List<ProductLineItem> productItemList;

	public CustomerDto getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDto customer) {
		this.customer = customer;
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

	public List<ProductLineItem> getProductItemList() {
		return productItemList;
	}

	public void setProductItemList(List<ProductLineItem> productItemList) {
		this.productItemList = productItemList;
	}

}
