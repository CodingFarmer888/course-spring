package com.course.service;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.course.entity.Account;
import com.course.exception.ActionException;
import com.course.repository.AccountRepository;

@Service
public class AccountService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private AccountRepository accountRepository;

	@Transactional
	public Account transferMoney(String payerAccountNo, String payeeAccountNo, BigDecimal amount) throws Exception {
		Account payerAccount = accountRepository.findByAccountNo(payerAccountNo);
		
		if (payerAccount == null) {
			throw new ActionException("帳號錯誤");
		}
		if (payerAccount.getBalance().compareTo(amount) >= 0) {
			// 餘額充足，可以轉帳
			
			Account payeeAccount = accountRepository.findByAccountNo(payeeAccountNo);
			
			payerAccount.setBalance(payerAccount.getBalance().subtract(amount));
			accountRepository.save(payerAccount);
			// 在有可能出錯的時候，總是會出錯
			payeeAccount.setBalance(payeeAccount.getBalance().add(amount));
			accountRepository.save(payeeAccount);
		} else {
			logger.info("餘額不足：" + payerAccountNo);
			throw new ActionException("餘額不足");
		}
		
		return payerAccount;
	}
}
