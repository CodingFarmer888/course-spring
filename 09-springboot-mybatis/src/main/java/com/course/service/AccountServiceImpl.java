package com.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.mapper.AccountMapper;
import com.course.vo.Account;

@Service
public class AccountServiceImpl {
	@Autowired
	private AccountMapper acc;
	
	public void addAccount(Account account) {
		acc.add(account);
	}
	
	public Account login(String username, String password) {
		return acc.queryAccount(username, password);
	}
}
