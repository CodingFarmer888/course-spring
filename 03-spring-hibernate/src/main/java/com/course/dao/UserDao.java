package com.course.dao;

import java.util.List;

import com.course.entity.User;

public interface UserDao {

	// Create 新增
	void insert(User user);
	
	// Read 查詢	
	User findByUsername(String username);
	List<User> findAll();
	
	// Update 更新
	void save(User user);
	
	// Delete 刪除
	void delete(Long id);
}
