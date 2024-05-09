package com.course.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.course.dao.UserDao;
import com.course.dao.service.ConnectionService;
import com.course.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private ConnectionService connectionService;
	
	@Override
	public void insert(User user) {
		Session session = connectionService.getSession();
		// 開啟交易
		Transaction transaction = session.beginTransaction();
		// DB 操作
		session.save(user);
		// 提交
		transaction.commit();
		// 關閉連線
		session.close();
	}

	@Override
	public User findByUsername(String username) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		String sql = "select u from User u where u.username = ?1";
		Query<User> query = session.createQuery(sql, User.class);
		query.setParameter(1, username);
		List<User> resultList = query.getResultList();
		
		return resultList != null && resultList.size() > 0 ? resultList.get(0) : null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
