package com.edu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainAppOneToMany {

	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		config.addAnnotatedClass(Department.class);
		config.addAnnotatedClass(Employee.class);
		
	//	Configuration config = new Configuration()
	//			.configure("hibernate.cfg.xml")
	//			.addAnnotatedClass(Product.class);
		
		SessionFactory sf = config.buildSessionFactory();
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		tx.commit();
		session.close();

	}

}
