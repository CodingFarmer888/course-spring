package springMvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springMvc.dao.UserDao;
import springMvc.entity.UserEntity;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	public void addUser(String username, String password) {
		UserEntity user = new UserEntity();
		user.setUsername(username);
		user.setPassword(password);
		userDao.insert(user);
	}
	
	/**
	 * 查詢User
	 * @param username
	 * @param password
	 * @return
	 */
	public UserEntity findUser(String username, String password) {
		return userDao.findByUsernameAndPassword(username, password);
	}
}
