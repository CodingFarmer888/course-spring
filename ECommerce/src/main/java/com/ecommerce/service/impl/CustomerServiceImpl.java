package com.ecommerce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.CustomerDao;
import com.ecommerce.model.dto.CustomerDto;
import com.ecommerce.model.entity.Customer;
import com.ecommerce.model.sessionbean.LoginCustomer;
import com.ecommerce.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private LoginCustomer loginCustomer;
	
	@Override
	public Customer findCustomerById(String customerId) {
		return customerDao.findByCustomerId(customerId);
	}
	
	/**
	 * 顧客登入
	 */
	@Override
	public CustomerDto login(String customerId, String password) {
		
		Customer customer = customerDao.findByCustomerIdAndPassword(customerId, password);
		if (customer != null) {
			// 帳號密碼正確，進行後續登入作業，這裡寫入session
			loginCustomer.setCustomerKey(customer.getCustomerKey());
			loginCustomer.setCustomerId(customer.getCustomerId());
			loginCustomer.setName(customer.getName());
			loginCustomer.setNickname(customer.getNickname());
			loginCustomer.setEmail(customer.getEmail());
			loginCustomer.setPhone(customer.getPhone());
			
			CustomerDto dto = new CustomerDto();
			dto.setCustomerKey(customer.getCustomerKey());
			dto.setCustomerId(customer.getCustomerId());
			dto.setName(customer.getName());
			dto.setNickname(customer.getNickname());
			dto.setEmail(customer.getEmail());
			dto.setPhone(customer.getPhone());
			
			return dto;
		} else {
			return null;
		}
	}
	
	/**
	 * 登出
	 * 把該清除了東西清空
	 */
	@Override
	public void logout() {
		loginCustomer = new LoginCustomer();
	}
	
	/**
	 * 檢查是否是登入狀態
	 * @param customerId
	 * @return
	 */
	@Override
	public boolean checkLogin(String customerId) {
		if (loginCustomer != null && loginCustomer.getCustomerId() != null) {
			return loginCustomer.getCustomerId().equals(customerId);
		}
		return false;
	}




}
