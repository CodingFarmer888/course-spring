package com.course.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.dao.UserDao;
import com.course.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao; 
	
	/**
	 * 檢查登入邏輯
	 * @param username
	 * @param password
	 * @return
	 */
	public User checkUser(String username, String password) {
		User user = userDao.findByUsername(username);

		// 檢查帳號是否存在
		if (user != null) {
			// 檢查密碼是否正確
			if (password.equals(user.getPassword())) {
				return user;
			}
		}
		return null;
	}

	/**
	 * 新增使用者
	 * @param username
	 * @param password
	 */
	public void addUser(String username, String password) {
		// TODO: 檢查 username 是否存在
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		userDao.insert(user);
	}

}
