package com.course.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.model.entity.ProductEntity;
import com.course.model.session.CartSession;
import com.course.model.vo.CartVo;
import com.course.model.vo.ProductItem;
import com.course.model.vo.ProductVo;
import com.course.repository.ProductRepository;
import com.course.utils.EcUtils;

@Service
public class CartService {
	
	@Autowired
	private ProductRepository productRepo;
	
	/** Session 當中的購物車 */
	@Autowired
	private CartSession cart;

	@Autowired
	private EcUtils utils;
	
	/**
	 * 將商品加入購物車
	 * @param code
	 */
	public void addProductToCart(String code) {
		ProductEntity product = productRepo.findByCode(code);
		if (product != null) {
			if (cart == null) {
				// 防呆，如果購物車為null，建立一個新的購物車
				cart = new CartSession();
			}
			ProductVo productVo = utils.convertToVo(product);
			cart.getProductVoList().add(productVo);	
		}
	}
	
	/**
	 * 取得購物車
	 * @return
	 */
	public CartVo getCart() {
		CartVo cartVo = new CartVo();
		List<ProductVo> productVoList = cart.getProductVoList();
				
	    // 對 ProductVo 進行分組並累加數量
	    Map<ProductVo, Integer> productMap = productVoList.stream()
	        .collect(Collectors.groupingBy(vo -> vo, Collectors.summingInt(vo -> 1)));
		
	    // 將每個產品轉換為 ProductItem 並計算 totalAmount
	    List<ProductItem> productItemList = productMap.entrySet().stream()
	        .map(entry -> {
	            ProductVo productVo = entry.getKey();
	            Integer quantity = entry.getValue();
	            BigDecimal totalAmount = productVo.getSalesPrice().multiply(new BigDecimal(quantity));
	            return new ProductItem(productVo, quantity, totalAmount);
	        })
	        .collect(Collectors.toList());
		
		cartVo.setItemList(productItemList);
		return cartVo;
	}
	
	/**
	 * 從購物車移除商品，並回傳新的購物車
	 * @param code
	 * @return
	 */
	public CartVo removeProductFromCart(String code) {
		List<ProductVo> productList = cart.getProductVoList();
		ProductVo product = productList.stream().filter(p -> p.getCode().equals(code)).findFirst().orElse(null);
		if (product != null) {
			productList.remove(product);
		}
		cart.setProductVoList(productList);
		return getCart();
	}

}
