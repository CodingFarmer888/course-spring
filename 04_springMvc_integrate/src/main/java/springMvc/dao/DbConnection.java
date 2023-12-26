package springMvc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DbConnection {
	public static void main(String[] args) {
		DbConnection.getDb();
	}
	
	public static Session getDb() {
		Configuration configuration = new Configuration().configure();
		// 這裡會檢查XML有沒有問題
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		// like PreparedStatement
		Session session = sessionFactory.openSession();
		return session;
	}
}
