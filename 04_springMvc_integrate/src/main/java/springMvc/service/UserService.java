package springMvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springMvc.dao.UserDao;
import springMvc.entity.UserEntity;
import springMvc.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	/**
	 * 新增使用者
	 * @param userVo
	 */
	public boolean addUser(UserVo userVo) {
		
		// 先判斷email是否存在，如果存在不能往下新增
		UserEntity userEntity = userDao.findByEmail(userVo.getEmail());
		if (userEntity != null) {
			// email已存在
			return false;
		}
		
		UserEntity user = new UserEntity();
		user.setUsername(userVo.getUsername());
		user.setPassword(userVo.getPassword());
		user.setEmail(userVo.getEmail());
		userDao.insert(user);
		return true;
	}
	
	/**
	 * 更新使用者
	 * @param userVo
	 */
	public void updateUser(UserVo userVo) {
		// 先透過email搜尋
		UserEntity user = findUserByEmail(userVo.getEmail());
		if (user != null) {
			user.setPassword(userVo.getPassword());
			user.setUsername(userVo.getUsername());
			userDao.update(user);
		}
	}
	
	/**
	 * 查詢所有使用者
	 * @return
	 */
	public List<UserEntity> findAllUser() {
		List<UserEntity> userList = userDao.findAll();
		return userList;
	}
	
	/**
	 * 查詢User
	 * @param email
	 * @param password
	 * @return
	 */
	public UserEntity findUser(String email, String password) {
		return userDao.findByEmailAndPassword(email, password);
	}
	
	/**
	 * 透過Email查詢User
	 * @param email
	 * @return
	 */
	public UserEntity findUserByEmail(String email) {
		return userDao.findByEmail(email);
	}
	
}
