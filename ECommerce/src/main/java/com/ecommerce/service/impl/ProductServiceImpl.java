package com.ecommerce.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.ProductDao;
import com.ecommerce.dto.ProductDto;
import com.ecommerce.entity.Product;
import com.ecommerce.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	@Override
	public List<ProductDto> getAllProducts() {
		List<Product> productList = productDao.findAll();
		return productList.stream().map(product -> {
			return convertToProductDto(product);
		}).collect(Collectors.toList());
	}
	
	/**
	 * 將entity轉換成前端dto
	 * @param product
	 * @return
	 */
	private ProductDto convertToProductDto(Product product) {
		ProductDto dto = new ProductDto();
		dto.setProductId(product.getProductId());
		dto.setName(product.getName());
		dto.setBrand(product.getBrand());
		dto.setStatusDisp(product.getStatus() == 1 ? "上架" : "下架");
		dto.setListPriceDisp(toTwdAmountDisp(product.getProductPrice().getListPrice()));
		dto.setSalesPriceDisp(toTwdAmountDisp(product.getProductPrice().getSalesPrice()));
		return dto;
	}
	
	/**
	 * BigDecimal 轉 台幣顯示
	 * @param price
	 * @return
	 */
	private String toTwdAmountDisp(BigDecimal price) {
		BigDecimal scaledPrice = price.setScale(0, RoundingMode.HALF_UP);
		return scaledPrice.toString();
	}
}
