package springMvc.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springMvc.dao.ConnectionService;
import springMvc.dao.UserDao;
import springMvc.entity.UserEntity;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private ConnectionService connectionService;
	
	
	@Override
	public void insert(UserEntity userEntity) {
		Session session = connectionService.getSession();
		
		// 會操作到資料庫內容(非查詢)，需要先開啟交易
		Transaction transaction = session.beginTransaction();
		// 新增
		session.save(userEntity);
		// 提交
		transaction.commit();
	}
	
	
	@Override
	public UserEntity findByUsernameAndPassword(String username, String password) {
		Session session = connectionService.getSession();
		
		String sql = "select * from user u where u.username = ?1 and u.password = ?2 ";
		Query<UserEntity> query = session.createNativeQuery(sql, UserEntity.class);
		query.setParameter(1, username);
		query.setParameter(2, password);
		UserEntity userEntity = null;
		List<UserEntity> resultList = query.getResultList();
		if (resultList != null && resultList.size() > 0) {
			userEntity = resultList.get(0);
		}
		
		return userEntity;
	}



}
