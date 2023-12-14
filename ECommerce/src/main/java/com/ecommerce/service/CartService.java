package com.ecommerce.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.dao.OrderDao;
import com.ecommerce.dao.OrderProductDao;
import com.ecommerce.dao.ProductDao;
import com.ecommerce.error.ActionException;
import com.ecommerce.model.dto.ProductDto;
import com.ecommerce.model.entity.Order;
import com.ecommerce.model.entity.OrderProduct;
import com.ecommerce.model.entity.Product;
import com.ecommerce.model.sessionbean.LoginCustomer;
import com.ecommerce.model.vo.Cart;
import com.ecommerce.model.vo.ProductLineItem;

@Service
public class CartService {
	
	@Autowired
	private Cart cartInSession;
	
	@Autowired
	private LoginCustomer loginCustomer;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private OrderProductDao orderProductDao;
	
	@Autowired
	CustomerService customerService;
	
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
			ProductDto dto = productService.getProductById(productId);
			ProductLineItem lineItem = new ProductLineItem();
			lineItem.setProductDto(dto);
			lineItem.setQty(qty);
			cartInSession.getProductLineItemList().add(lineItem);
		}

		cartInSession.setTotalAmount(calcAmount(cartInSession.getProductLineItemList()));
		// 因為不能在session的購物車不能直接往前端送，需要重新assign
		Cart cart = new Cart();
		cart.setProductLineItemList(cartInSession.getProductLineItemList());
		
		// 計算購物車金額
		cart.setTotalAmount(cartInSession.getTotalAmount());
		return cart; 
	}
	
	/**
	 * 計算總金額
	 * @param productLineItemList
	 * @return
	 */
	private BigDecimal calcAmount(List<ProductLineItem> productLineItemList) {
		BigDecimal totalAmount = new BigDecimal("0");
		for (ProductLineItem productItem : productLineItemList) {
			// 購買個數
			Integer qty = productItem.getQty();
			// 售價
			BigDecimal salesPrice = productItem.getProductDto().getSalesPrice();
			BigDecimal subTotal = salesPrice.multiply(new BigDecimal(qty));
			totalAmount = totalAmount.add(subTotal);
		}
		
		return totalAmount;
	}
	
	/**
	 * 結帳，將購物車轉換為Order
	 * @throws ActionException 
	 */
	public void checkOut(String customerId) throws ActionException {
		// 判斷是否是登入狀態，如果不是登入狀態，不能結帳
		
		if (!customerService.checkLogin(customerId)) {
			throw new ActionException("Not Login", "9999");
		}
		List<ProductLineItem> productLineItems = cartInSession.getProductLineItemList();
		
		Order order = new Order();
		order.setCustomerKey(loginCustomer.getCustomerKey());
		order.setOrderDate(new Date());
		
		List<Product> productList = new ArrayList<>();
		
		Map<Product, Integer> productQtyMap = new HashMap<>();
		for (ProductLineItem productLineItem : productLineItems) {
			
			ProductDto dto = productLineItem.getProductDto();
			Product product = productDao.findByProductId(dto.getProductId());
			productList.add(product);
			productQtyMap.put(product, productLineItem.getQty());
		}
		
		// ManyToMany
//		order.setProducts(productList);
		order.setTotalAmount(cartInSession.getTotalAmount());
		saveOrder(order, productQtyMap);
		
	}
	
	@Transactional(rollbackFor = {Exception.class})
	private void saveOrder(Order order, Map<Product, Integer> productQtyMap) {
		orderDao.save(order);
		
		// 儲存OrderProduct

		for (Entry<Product, Integer> entry : productQtyMap.entrySet()) {
			OrderProduct orderProduct = new OrderProduct();
			orderProduct.setOrder(order);
			orderProduct.setProduct(entry.getKey());
			orderProduct.setQty(entry.getValue());
			orderProductDao.save(orderProduct);
			
		}
	}
	
}
