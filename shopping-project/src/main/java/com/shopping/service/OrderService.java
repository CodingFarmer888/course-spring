package com.shopping.service;

import java.util.List;

import com.shopping.entity.Order;
import com.shopping.entity.OrderDetail;
import com.shopping.model.CartInfo;

public interface OrderService {

	Integer getMaxOrderNum();

	void saveOrder(CartInfo cartInfo);

	List<Order> listOrderInfo(Integer page, Integer maxResult) ;

	Order getOrderInfo(String orderId);

	List<OrderDetail> listOrderDetails(String orderId) ;
}
