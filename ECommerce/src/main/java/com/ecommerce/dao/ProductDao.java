package com.ecommerce.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.model.entity.Product;

public interface ProductDao extends JpaRepository<Product, Long> {

	public Product findByProductId(String productId);
	
	public Page<Product> findByNameLike(String searchKeyword, Pageable pageable);

	public List<Product> findByNameLike(String string);
	
}
