package com.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

	Account findByAccountNo(String accountNo);
}
