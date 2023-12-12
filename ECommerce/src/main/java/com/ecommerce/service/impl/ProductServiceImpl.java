package com.ecommerce.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.dao.ProductDao;
import com.ecommerce.dao.ProductPriceDao;
import com.ecommerce.model.dto.ProductDto;
import com.ecommerce.model.entity.Product;
import com.ecommerce.model.entity.ProductPrice;
import com.ecommerce.model.vo.Cart;
import com.ecommerce.model.vo.ProductLineItem;
import com.ecommerce.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ProductPriceDao productPriceDao;
	
	@Autowired
	private Cart cartInSession;
	
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
		dto.setStatus(product.getStatus());
		dto.setStatusDisp(product.getStatus() == 1 ? "上架" : "下架");
		dto.setListPrice(product.getProductPrice().getListPrice());
		dto.setListPriceDisp(toTwdAmountDisp(product.getProductPrice().getListPrice()));
		dto.setSalesPrice(product.getProductPrice().getSalesPrice());
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
	
	/**
	 * 商品加入購物車
	 * TODO: 業務邏輯回家作業
	 */
	public Cart addToCart(String productId, Integer qty) {

		// 取得Session中的購物車物件
		List<ProductLineItem> itemList = cartInSession.getProductLineItemList();
		// 判斷本次所加的商品是否已經存在購物車當中
		ProductLineItem productLineItem = itemList.stream().filter(item -> item.getProductDto().getProductId().equals(productId)).findFirst().orElse(null);
		if (productLineItem != null) {
			// 商品已經存在購物車，直接加數量
			productLineItem.setQty(productLineItem.getQty() + qty);
		} else {
			// 本次新增商品，從DB取得商品資料
			ProductDto dto = getProductById(productId);
			ProductLineItem lineItem = new ProductLineItem();
			lineItem.setProductDto(dto);
			lineItem.setQty(qty);
			cartInSession.getProductLineItemList().add(lineItem);
		}
		
		// 因為不能在session的購物車不能直接往前端送，需要重新assign
		Cart cart = new Cart();
		cart.setProductLineItemList(cartInSession.getProductLineItemList());
		
		return cart; 
	}
	
	public List<ProductDto> getProductWithPageable(Integer pageNum, Integer pageSize) {
		// 第幾頁, 一頁幾個, 排序規則
		Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.by("productPrice.salesPrice"));
		Page<Product> pageProduct = productDao.findAll(pageable);
		return pageProduct.stream().map(p -> convertToProductDto(p)).collect(Collectors.toList());
	}

	@Override
	public List<ProductDto> getSearchProducts(String searchKeyword, Integer pageNum, Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.by("productPrice.salesPrice"));
		
		Page<Product> pageProduct = productDao.findByNameLike("%"+searchKeyword+"%", pageable);
		return pageProduct.stream().map(p -> convertToProductDto(p)).collect(Collectors.toList());
	}
	
	@Override
	public List<ProductDto> searchProductsWithoutPages(String searchKeyword) {		
		List<Product> pageProduct = productDao.findByNameLike("%"+searchKeyword+"%");
		return pageProduct.stream().map(p -> convertToProductDto(p)).collect(Collectors.toList());
	}

	/**
	 * 更新商品資料
	 */
	@Override
	public ProductDto updateProdcut(ProductDto productDto) {
		Product product = updateProductTransaction(productDto);
		return convertToProductDto(product);
	}
	
	@Transactional(rollbackFor = { Exception.class })
	private Product updateProductTransaction(ProductDto productDto) {
		// 透過productId先把商品找出來
		String productId = productDto.getProductId();
		Product product = productDao.findByProductId(productId);
		product.setName(productDto.getName());
		product.setBrand(productDto.getBrand());
		product.setBrand(productDto.getBrand());
		product.setStatus(productDto.getStatus());
		product.getProductPrice().setListPrice(productDto.getListPrice());
		product.getProductPrice().setSalesPrice(productDto.getSalesPrice());
		product.setImageData(productDto.getImageData());
		productDao.save(product);
		
		return product;
	}



	@Override
	@Transactional(rollbackFor = { Exception.class })
	public void deleteProductById(String productId) {
		productDao.deleteByProductId(productId);
	}
}
