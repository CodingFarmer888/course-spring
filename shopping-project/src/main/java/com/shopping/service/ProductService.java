package com.shopping.service;

import java.util.List;

import com.shopping.entity.Product;

public interface ProductService {
	Product save(Product p);

	Product findProduct(String code);

	List<Product> getAllProducts();

	List<Product> getPageProducts(Integer pageNo, Integer pageSize, String sortBy);
}
