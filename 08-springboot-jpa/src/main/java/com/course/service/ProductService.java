package com.course.service;

import java.util.List;

import com.course.entity.ProductEntity;

public interface ProductService {
	
	/** 新增 */
	ProductEntity insertProduct(String code, String name, String price, String imageUrl);

	/** 查詢 - 全部商品 */
	List<ProductEntity> getAllProducts();
	
	/** 查詢 - By Id */
	ProductEntity getProductById(Long id);
	
	/** 更新 */
	ProductEntity updateProduct(Long id, String code, String name, String price, String imageUrl);

	/** 刪除 */
	void deleteById(Long id);
	
	List<ProductEntity> getByCode(String code);
	
	List<ProductEntity> getByCodeAndName(String code, String name);
	
	List<ProductEntity> getByCodeOrName(String code, String name);
	
	List<ProductEntity> getPriceGreaterThan(String price);
	
	List<ProductEntity> getPriceGreaterThanEqualAndPriceLessThanEqual(String minPrice, String maxPrice);
	
	List<ProductEntity> getPriceBetween(String minPrice, String maxPrice);
	
	List<ProductEntity> getCreateDateBetween(String startDate, String endDate);
	
	List<ProductEntity> getNameLike(String name);
	
	List<ProductEntity> getNameIn(List<String> nameList);
	
	List<ProductEntity> getNameLikeOrderByPrice(String name);
	
	Integer countByName(String name);

}
