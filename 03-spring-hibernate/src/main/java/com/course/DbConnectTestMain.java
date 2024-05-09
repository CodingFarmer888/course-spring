package com.course;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DbConnectTestMain {

	public static void main(String[] args) {
		// 通過調用 configure() 方法，從 hibernate.cfg.xml 文件中讀取配置設定，根據文件中的設置來初始化 Hibernate。
		Configuration configuration = new Configuration().configure();
		// SessionFactory 是 Hibernate 中的核心介面，負責創建和管理 Session 物件
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		// Session 是 Hibernate 中用於與資料庫進行交互的主要介面，用於執行CRUD操作
		Session session = sessionFactory.openSession();
	}

}
