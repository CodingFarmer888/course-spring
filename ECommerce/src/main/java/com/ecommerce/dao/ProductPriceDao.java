package com.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.model.entity.ProductPrice;

public interface ProductPriceDao extends JpaRepository<ProductPrice, Long> {

}
