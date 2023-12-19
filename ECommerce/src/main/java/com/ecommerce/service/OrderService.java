package com.ecommerce.service;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.OrderCustomDao;
import com.ecommerce.dao.OrderDao;
import com.ecommerce.model.dto.OrderDto;
import com.ecommerce.model.dto.OrderProductDto;
import com.ecommerce.model.dto.ProductDto;
import com.ecommerce.model.entity.Order;
import com.ecommerce.model.vo.ProductLineItem;

@Service
public class OrderService {
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private OrderCustomDao orderCustomDao;

	public List<Order> getOrderByCustomerKey(Long customerKey) {
		return orderDao.findByCustomerKey(customerKey);
	}
	
	public List<OrderDto> xxx(String customerId, String startDate, String endDate) {
		
		
		List<OrderProductDto> orderProductList = orderCustomDao.getOrdersByCondition(customerId, startDate, endDate);
		
		// 用OrderKey群組
        Map<Long, List<OrderProductDto>> groupedMap= orderProductList.stream()
                .collect(Collectors.groupingBy(OrderProductDto::getOrderKey));
        
        for (Entry<Long, List<OrderProductDto>> entry: groupedMap.entrySet()) {
        	
        	OrderDto orderDto = new OrderDto();
        	List<OrderProductDto> dtoList = entry.getValue();
        	orderDto.setTotalAmount(dtoList.get(0).getTotalAmount());
        	orderDto.setOrderDate(dtoList.get(0).getOrderDate());
        	List<ProductLineItem> productItemList;
        	dtoList.stream().map(d -> {
        		ProductLineItem lineItem = new ProductLineItem();
        		ProductDto productDto = new ProductDto();
        		lineItem.setQty(d.getProductQty());
        		// TODO 
//        		productDto.set
        		return null;
        	}).collect(Collectors.toList());
        	
        }
        
		for (OrderProductDto dto : orderProductList) {
			System.out.println(dto.getProductName());
		}
		
		
		return null;
		
	}
}
