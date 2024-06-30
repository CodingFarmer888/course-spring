package com.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.course.service.AccountServiceImpl;
import com.course.vo.Account;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountServiceImpl asi;
	
	@PostMapping("/add")
	public void add(@RequestBody Account account)
	{
		System.out.println(account);
		asi.addAccount(account);
	}
	
//	@PostMapping("/login")
//	public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
//        Account account = asi.login(username, password);
//
//        if (account != null) {
//            return "Login successful";
//        } else {
//            return "Login failed";
//        }
//    }
	
	@PostMapping("/login")
	public String login(@RequestBody Account loginAccount) {
        Account account = asi.login(loginAccount.getUsername(), loginAccount.getPassword());

        if (account != null) {
            return "Login successful";
        } else {
            return "Login failed";
        }
    }
}
