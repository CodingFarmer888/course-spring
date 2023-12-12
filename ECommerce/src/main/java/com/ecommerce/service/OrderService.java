package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.OrderDao;
import com.ecommerce.model.entity.Order;

@Service
public class OrderService {
	
	@Autowired
	private OrderDao orderDao;

	public List<Order> getOrderByCustomerKey(Long customerKey) {
		return orderDao.findByCustomerKey(customerKey);
	}
}
