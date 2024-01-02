package springMvc.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;

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
		// 關閉連線
		session.close();
	}
	
	@Override
	public void update(UserEntity userEntity) {
		Session session = connectionService.getSession();
		// 開啟交易
		Transaction transaction = session.beginTransaction();
		// 更新
		session.update(userEntity);
		// 提交
		transaction.commit();
		// 關閉連線
		session.close();
	}
	
	@Override
	public void delete(UserEntity userEntity) {
		Session session = connectionService.getSession();
		// 開啟交易
		Transaction transaction = session.beginTransaction();
		// 刪除
		session.delete(transaction);
		// 提交
		transaction.commit();
		// 關閉連線
		session.close();
	}
	
	/**
	 * 查詢全部使用者
	 */
	@Override
	public List<UserEntity> findAll() {
		Session session = connectionService.getSession();
		// JPQL
		String sql = "select u from UserEntity u ";
		Query<UserEntity> query = session.createQuery(sql, UserEntity.class);
		
		// NativeSQL
		// String nativeSql = "select * from user ";
		// Query<UserEntity> query = session.createNativeQuery(nativeSql, UserEntity.class);

		// 查詢結果resultList
		List<UserEntity> resultList = query.getResultList();
		
		// 關閉連線
		session.close();
		return resultList;
	}
	
	
	/**
	 * 透過email跟密碼查詢
	 * 判斷是否登入成功
	 */
	@Override
	public UserEntity findByEmailAndPassword(String email, String password) {
		Session session = connectionService.getSession();
		
		String sql = "select * from user u where u.email = :email and u.password = :password ";
		Query<UserEntity> query = session.createNativeQuery(sql, UserEntity.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		UserEntity userEntity = null;
		List<UserEntity> resultList = query.getResultList();
		if (resultList != null && resultList.size() > 0) {
			userEntity = resultList.get(0);
		}
		// 關閉連線
		session.close();
		return userEntity;
	}

	@Override
	public UserEntity findByEmail(String email) {
		Session session = connectionService.getSession();

		String sql = "select u from UserEntity u where u.email = ?1 ";
		Query<UserEntity> query = session.createQuery(sql, UserEntity.class);
		query.setParameter(1, email);
		UserEntity user = null;
		try {
			user = query.getSingleResult();
		} catch (NoResultException e) {
			// 如果沒有取得資料，會拋出Exception，不處理exception
			// javax.persistence.NoResultException: No entity found for query
		}
		// 關閉連線
		session.close();
		
		return user;
	}



}
