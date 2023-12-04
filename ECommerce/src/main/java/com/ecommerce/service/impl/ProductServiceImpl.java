package com.ecommerce.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.dao.ProductDao;
import com.ecommerce.dao.ProductPriceDao;
import com.ecommerce.dto.ProductDto;
import com.ecommerce.entity.Product;
import com.ecommerce.entity.ProductPrice;
import com.ecommerce.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ProductPriceDao productPriceDao;
	
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
		// 將Bytep[]轉成Base64給頁面呈現
		String base64Image = Base64.getEncoder().encodeToString(product.getImageData());
		// 圖檔需要指定格式，這裡設定為jpg，如果有其他格式，需要另外指定
		dto.setImgBase64("data:image/jpg;base64," + base64Image);
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

	/**
	 * 新增商品
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void addProduct(ProductDto dto) {
		Product product = convertDtoToProduct(dto);
		productDao.save(product);
		
		/**
		 *  在關聯當中，如果沒設定 @JoinColumn(insertable = false)，在save的過程，會一併insert ProductPrice
		 *  問題出在ProductPrice的ProductKey是要等Product Insert完成之後才會返回的值
		 *  所以拆成兩段，先完成Product的save之後，再將ProductKey取出回填ProductPrice
		 */
		ProductPrice productPrice = new ProductPrice();
		productPrice.setProductKey(product.getProductKey());
		productPrice.setListPrice(dto.getListPrice());
		productPrice.setSalesPrice(dto.getSalesPrice());
		productPriceDao.save(productPrice);
	}
	
	private Product convertDtoToProduct(ProductDto dto) {
		Product product = new Product();
		product.setProductId(dto.getProductId());
		product.setName(dto.getName());
		product.setBrand(dto.getBrand());
		product.setStatus(dto.getStatus());
		product.setImageData(dto.getImageData());
		return product;
	}

	@Override
	public ProductDto getProductById(String productId) {
		Product product = productDao.findByProductId(productId);
		return convertToProductDto(product);
	}
}
