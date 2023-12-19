package com.ecommerce.dao;

import java.util.List;

import com.ecommerce.model.dto.OrderProductDto;

public interface OrderCustom {

	public List<OrderProductDto> getOrdersByCondition(String customerId, String startDate, String endDate);
}
