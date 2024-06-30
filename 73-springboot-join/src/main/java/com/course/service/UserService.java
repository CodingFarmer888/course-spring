package com.course.service;

import java.util.List;

import com.course.dto.UserRptDto;

public interface UserService {
	
	List<UserRptDto> findOrdersByUserId(Long userId);
	
	
	
}
