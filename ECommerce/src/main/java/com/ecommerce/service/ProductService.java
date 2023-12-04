package com.ecommerce.service;

import java.util.List;

import com.ecommerce.dto.ProductDto;

public interface ProductService {

	/** 取得所有商品列表 */
	public List<ProductDto> getAllProducts();
	
	public ProductDto getProductById(String productId);
	
	/** 新增商品 */
	public void addProduct(ProductDto dto);
}
