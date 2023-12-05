package com.ecommerce.service;

import com.ecommerce.model.entity.Customer;

public interface CustomerService {

	public Customer findCustomerById(String customerId);
	
	/** 登入 */
	public Customer login(String customerId, String password);
	
	/** 登出 */
	public void logout();
	
	/** 登入檢查 */
	public boolean checkLogin(String customerId);
}
