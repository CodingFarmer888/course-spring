package com.course.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.entity.Account;
import com.course.service.AccountService;
import com.course.service.FirstService;

@RestController
@RequestMapping("/transactionManagerController")
public class TransactionManagerController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private FirstService firstService;
	
	
	@PostMapping("/transactionalRollbackFor")
	public Account transferMoney(String srcAccountNo, String targetAccountNo, Integer amount) throws IOException {
		return accountService.transfer(srcAccountNo, targetAccountNo, amount);
	}
	
	@PostMapping(value = "/propagationRequired")
	public ResponseEntity<String> propagationRequired(){
		// REQUIRED(預設)：延續使用前一個交易，如果沒有的話就建立一個新的交易
		// 執行結果：交易一、交易二資料一起 commit、rollback 
		firstService.required_required();
		
		return ResponseEntity.ok("Propagation.REQUIRED");
	}
	
	@PostMapping(value = "/propagationRequiresNew")
	public ResponseEntity<String> propagationRequiresNew(){
    	// REQUIRES_NEW：建立一個新的交易，如果現存一個交易的話就先暫停，並啟始一個新獨立的交易來執行    	
    	// 執行結果：交易一資料於交易二資料commit之後commit
		firstService.required_requiredNew();
		
		return ResponseEntity.ok("Propagation.REQUIRES_NEW");
	}
	
	@PostMapping(value = "/propagationSupports")
	public ResponseEntity<String> propagationSupports(){
		
		// SUPPORTS：被調用者是否有事務，完全依賴於調用者，調用者有事務則有事務，調用者沒事務則沒事務。
		
		// 情境一：被調用者拋出異常的情況下，如果仍能查詢到數據，說明事務沒有回滾，說明被調用者沒有事務
		firstService.noTransaction_supportsHasException();
		
		// 情境二：調用者拋出異常情況下，結果查不到數據，說明兩個方法是在同一個事務中
		// firstService.hasTransactionHasException_supports();
		
		return ResponseEntity.ok("Propagation.SUPPORTS");
	}
	
	@PostMapping(value = "/propagationNotSupports")
	public ResponseEntity<String> propagationNotSupports(){
		
		// NOT_SUPPORTED：無論調用者是否有事務，被調用者都不以事務的方法運行
		
		// 情境一：被調用者都不會有事務，那麼在拋異常之後能查到相應的數據
		firstService.noTransaction_notSupportsHasException();
		
		// 情境二：在調用者有事務的情況下，被調用者也會在無事務環境下運行，所以依然能查到數據
		// firstService.hasTransactionHasException_notSupports();
		
		return ResponseEntity.ok("Propagation.NOT_SUPPORTED");
	}
	
	@PostMapping(value = "/propagationMandatory")
	public ResponseEntity<String> propagationMandatory(){
		
		// MANDATORY：方法必須在一個現存的交易中進行，否則丟出例外		
		// org.springframework.transaction.IllegalTransactionStateException:
		// No existing transaction found for transaction marked with propagation 'mandatory'
		firstService.mandatory();
		
		return ResponseEntity.ok("Propagation.MANDATORY");
	}
	
	@PostMapping(value = "/propagationNever")
	public ResponseEntity<String> propagationNever(){
		
		// NEVER：指被調用者不應在事務交易中進行，如果有的話就丟出例外
		// org.springframework.transaction.IllegalTransactionStateException:
		// Existing transaction found for transaction marked with propagation 'never' 
		firstService.hasTransaction_Never();
		
		return ResponseEntity.ok("Propagation.NEVER");
	}
	
}
