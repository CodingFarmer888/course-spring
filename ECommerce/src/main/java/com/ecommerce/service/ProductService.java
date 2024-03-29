package com.ecommerce.service;

import java.util.List;

import com.ecommerce.model.dto.ProductDto;
import com.ecommerce.model.vo.Cart;

public interface ProductService {

	/** 取得所有商品列表 */
	public List<ProductDto> getAllProducts();
	
	public ProductDto getProductById(String productId);
	
	/** 新增商品 */
	public void addProduct(ProductDto dto);

	public Cart addToCart(String productId, Integer qty);
	
	public List<ProductDto> getProductWithPageable(Integer pageNum, Integer pageSize);
	
	public List<ProductDto> getSearchProducts(String searchKeyword, Integer pageNum, Integer pageSize);

	List<ProductDto> searchProductsWithoutPages(String searchKeyword);
	
	/** 修改商品 */
	public ProductDto updateProdcut(ProductDto dto);
	
	/** 透過productId 刪除商品 */
	public void deleteProductById(String productId);
	
}
