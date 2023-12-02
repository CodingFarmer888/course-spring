package com.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.CustomerEntity;

public interface CustomerDao extends JpaRepository<CustomerEntity, Long> {

	public CustomerEntity findByCustomerId(String customerId);

}
