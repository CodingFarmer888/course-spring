package com.shopping.utils;

import com.shopping.entity.Product;
import com.shopping.model.ProductInfo;

public class ProductUtils {

	public static ProductInfo convertEntityToInfo(Product product) {
		ProductInfo info = new ProductInfo();
		info.setCode(product.getCode());
		info.setName(product.getName());
		info.setPrice(product.getPrice());
		info.setImageUrl("http://localhost:8080/images/" + product.getImageUrl());
		return info;
	}
}
