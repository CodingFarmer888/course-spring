package springMvc.dao;

import java.util.List;

import springMvc.entity.UserEntity;

public interface UserDao {

	/** Create 新增 */
	public void insert(UserEntity userEntity);
	
	/** Update 更新 */
	public void update(UserEntity userEntity);
	
	/**  Delete 刪除 */
	public void delete(UserEntity userEntity);
	
	/**  Read 查詢 */
	/** 查詢全部使用者 */
	public List<UserEntity> findAll();
	
	/** 條件查詢：夠過email跟password查詢 */
	public UserEntity findByEmailAndPassword(String email, String password);
	
	/** 條件查詢：夠過email查詢 */
	public UserEntity findByEmail(String email);
}
