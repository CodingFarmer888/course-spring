package springMvc.dao;

import springMvc.entity.UserEntity;

public interface UserDao {

	// Create
	public void insert(UserEntity userEntity);
	
	// Read
	public UserEntity findByUsernameAndPassword(String username, String password);
	
	// Update
	
	// Delete
}
