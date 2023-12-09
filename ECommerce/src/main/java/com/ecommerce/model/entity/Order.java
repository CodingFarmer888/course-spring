package com.ecommerce.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ORDER_ITEM")
public class Order {

	/** 訂單鍵值 */
	@Id
	@Column(name = "ORDER_KEY")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderKey;
	
	/** 顧客鍵值(外鍵) */
	@Column(name = "CUSTOMER_KEY")
	private Long customerKey;
	
	/** 顧客 多對一 關聯*/
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CUSTOMER_KEY", insertable = false, updatable = false)
	private Customer customer;

	public Long getOrderKey() {
		return orderKey;
	}

	public void setOrderKey(Long orderKey) {
		this.orderKey = orderKey;
	}

	public Long getCustomerKey() {
		return customerKey;
	}

	public void setCustomerKey(Long customerKey) {
		this.customerKey = customerKey;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
