package com.course.service;

import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.course.entity.Account;
import com.course.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Transactional(rollbackFor = { Exception.class }, timeout = 10000)
	public Account transfer(String sourceAccountNo, String targetAccountNo, Integer amount) throws IOException {
		Account srcAccount = accountRepository.findByAccountNo(sourceAccountNo);
		
		Account targetAccount = accountRepository.findByAccountNo(targetAccountNo);
	
		srcAccount.setAmount(srcAccount.getAmount() - amount);
		srcAccount = accountRepository.save(srcAccount);

		// throw RuntimeException (unCheck Exception)
		// Transactional 預設 rollback RuntimeException
		// Integer.parseInt("abc");

		targetAccount.setAmount(targetAccount.getAmount() + amount);
		accountRepository.save(targetAccount);
		
		// throw Exception(Check Exception)
		// Transactional 不會 rollback Exception 須設置 rollbackFor
		FileReader fr = new FileReader("C:/User.txt");
		fr.close();
		
		
		return srcAccount;
	}
}
