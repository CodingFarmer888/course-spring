package com.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.Customer;

public interface CustomerDao extends JpaRepository<Customer, Long> {

	public Customer findByCustomerId(String customerId);

}
