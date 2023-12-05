package com.ecommerce.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 顧客基本資料
 */
@Entity
@Table(name = "CUSTOMER")
public class Customer {
	
	@Id
	@Column(name = "CUSTOMER_KEY")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerKey;
	
	@Column(name = "CUSTOMER_ID")
	private String customerId;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "NICKNAME")
	private String nickname;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PHONE")
	private String phone;

	public Long getCustomerKey() {
		return customerKey;
	}

	public void setCustomerKey(Long customerKey) {
		this.customerKey = customerKey;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
