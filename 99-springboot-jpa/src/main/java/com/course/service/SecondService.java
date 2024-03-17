package com.course.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.course.entity.Account;
import com.course.repository.AccountRepository;

@Service
public class SecondService {
	
	private static Logger logger = LoggerFactory.getLogger(SecondService.class);
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void required(){
		logger.info("========== SecondService REQUIRED start ==========");
		saveAccount();
		logger.info("========== SecondService REQUIRED end ==========");
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void requiresNew(){
		logger.info("========== SecondService REQUIRES_NEW start ==========");
		saveAccount();
		logger.info("========== SecondService REQUIRES_NEW end ==========");		
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void supportsHasException(){
		logger.info("========== SecondService SUPPORTS start ==========");
		saveAccount();
		Integer.parseInt("ABC");
		logger.info("========== SecondService SUPPORTS end ==========");
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void supportsNoException(){
		logger.info("========== SecondService SUPPORTS start ==========");
		saveAccount();		
		logger.info("========== SecondService SUPPORTS end ==========");
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void notSupportsHasException(){
		logger.info("========== SecondService NOT_SUPPORTED start ==========");
		saveAccount();
		Integer.parseInt("ABC");
		logger.info("========== SecondService NOT_SUPPORTED end ==========");
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void notSupportsNoException(){
		logger.info("========== SecondService NOT_SUPPORTED start ==========");
		saveAccount();		
		logger.info("========== SecondService NOT_SUPPORTED end ==========");
	}
	
	@Transactional(propagation = Propagation.NEVER)
	public void never() {
		logger.info("========== SecondService NEVER start ==========");
		saveAccount();		
		logger.info("========== SecondService NEVER end ==========");		
	}
	
	@Transactional(propagation = Propagation.NESTED)
	public void nestedHasException() {
		logger.info("========== SecondService NESTED start ==========");
		saveAccount();
		Integer.parseInt("ABC");
		logger.info("========== SecondService NESTED end ==========");		
	}
	
	@Transactional(propagation = Propagation.NESTED)
	public void nested() {
		logger.info("========== SecondService NESTED start ==========");
		saveAccount();
		logger.info("========== SecondService NESTED end ==========");		
	}
	
	private void saveAccount() {
		Account account = new Account();
		account.setAccountNo("SecondAccount");
		account.setAmount(8888);
		accountRepository.save(account);
	
	}
	
}
