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
public class FirstService {
	
	private static Logger logger = LoggerFactory.getLogger(FirstService.class);
	
	@Autowired
	private SecondService secondService;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void required_required(){
		logger.info("========== FirstService REQUIRED start ==========");
		saveAccount();
		secondService.required();
		logger.info("========== FirstService REQUIRED end ==========");
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void required_requiredNew(){
		logger.info("========== FirstService REQUIRED start ==========");
		saveAccount();
		secondService.requiresNew();
		logger.info("========== FirstService REQUIRED end ==========");
	}	
	
	public void noTransaction_supportsHasException(){
		logger.info("========== FirstService No Transaction start ==========");
		secondService.supportsHasException();
		logger.info("========== FirstService No Transaction end ==========");
	}
	
	@Transactional
	public void hasTransactionHasException_supports(){
		logger.info("========== FirstService Has Transaction start ==========");
		saveAccount();
		secondService.supportsNoException();
		Integer.parseInt("ABC");
		logger.info("========== FirstService Has Transaction end ==========");		
	}
	
	public void noTransaction_notSupportsHasException(){
		logger.info("========== FirstService No Transaction start ==========");
		secondService.notSupportsHasException();
		logger.info("========== FirstService No Transaction end ==========");
	}
	
	@Transactional
	public void hasTransactionHasException_notSupports(){
		logger.info("========== FirstService Has Transaction start ==========");
		saveAccount();
		secondService.notSupportsNoException();
		Integer.parseInt("ABC");
		logger.info("========== FirstService Has Transaction end ==========");		
	}
	
	@Transactional(propagation = Propagation.MANDATORY)
	public void mandatory(){
		logger.info("========== FirstService MANDATORY start ==========");
		saveAccount();
		logger.info("========== FirstService MANDATORY end ==========");
	}
	
	@Transactional
	public void hasTransaction_Never() {
		logger.info("========== FirstService Has Transaction start ==========");
		saveAccount();
		secondService.never();
		logger.info("========== FirstService Has Transaction end ==========");	
	}
	
	public void noTransaction_NestedHasException() {
		logger.info("========== FirstService No Transaction start ==========");
		secondService.nestedHasException();
		logger.info("========== FirstService No Transaction end ==========");		
	}
	
	@Transactional
	public void hasTransaction_Nested() {
		logger.info("========== FirstService Has Transaction start ==========");
		saveAccount();
		secondService.nested();
		logger.info("========== FirstService Has Transaction end ==========");		
	}
	
	private void saveAccount() {
		
		Account account = new Account();
		account.setAccountNo("FirstAccount");
		account.setAmount(9999);
		accountRepository.save(account);
	
	}
	
}
