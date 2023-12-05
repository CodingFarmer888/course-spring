package com.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.model.entity.Customer;

public interface CustomerDao extends JpaRepository<Customer, Long> {

	public Customer findByCustomerId(String customerId);
	
	public Customer findByCustomerIdAndPassword(String customerId, String password);

}
