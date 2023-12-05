package com.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.model.entity.Product;

public interface ProductDao extends JpaRepository<Product, Long> {

	public Product findByProductId(String productId);
}
