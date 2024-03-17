package com.course.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.entity.Account;
import com.course.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@PostMapping("/transferMoney")
	public Account transferMoney(String srcAccountNo, String targetAccountNo, Integer amount) throws IOException {
		return accountService.transfer(srcAccountNo, targetAccountNo, amount);
	}
}
