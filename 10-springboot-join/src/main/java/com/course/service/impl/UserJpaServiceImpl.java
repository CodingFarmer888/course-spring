package com.course.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.course.dao.UserJpaDao;
import com.course.dto.UserRptDto;
import com.course.service.UserService;

public class UserJpaServiceImpl implements UserService {

	@Autowired
	private UserJpaDao userDao;
	
	@Override
	public List<UserRptDto> findOrdersByUserId(Long userId) {
		return userDao.findUserOrders(userId);
	}

}
