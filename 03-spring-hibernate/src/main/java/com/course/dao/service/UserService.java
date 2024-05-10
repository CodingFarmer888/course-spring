package com.course.dao.service;

import java.util.List;

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
	
	/**
	 * 搜尋使用者
	 * @param username
	 * @return
	 */
	public User findUser(String username) {
		return userDao.findByUsername(username);
	}
	
	/**
	 * 更新使用者
	 * @param username
	 * @param password
	 */
	public void updateUser(String username, String password) {
		User user = this.findUser(username);
		if (user != null) {
			user.setPassword(password);
			userDao.save(user);			
		}
	}
	
	/**
	 * 刪除使用者
	 * @param username
	 * @param password
	 */
	public void deleteUser(String username) {
		User user = this.findUser(username);
		if (user != null) {
			userDao.delete(user);			
		}
	}

	public List<User> getAllUsers() {
		return userDao.findAll();
	}
}
