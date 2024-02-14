package com.shopping.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.shopping.entity.Product;
import com.shopping.model.ProductInfo;

public interface ProductService {
	Product save(Product p);

	Product findProduct(String code);

	List<Product> getAllProducts();
	
	Page<ProductInfo> getProductsPage(Integer pageNo, Integer pageSize);

	List<Product> getPageProducts(Integer pageNo, Integer pageSize, String sortBy);
}
