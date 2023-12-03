package com.ecommerce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.CustomerDao;
import com.ecommerce.entity.Customer;
import com.ecommerce.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	public Customer findCustomerById(String customerId) {
		return customerDao.findByCustomerId(customerId);
	}


}
