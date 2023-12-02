package com.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.ProductEntity;

public interface ProductDao extends JpaRepository<ProductEntity, Long> {

}
