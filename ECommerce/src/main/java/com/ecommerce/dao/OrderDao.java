package com.ecommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.model.entity.Order;

public interface OrderDao extends JpaRepository<Order, Long> {

	List<Order> findByCustomerKey(Long customerKey);
	
}
