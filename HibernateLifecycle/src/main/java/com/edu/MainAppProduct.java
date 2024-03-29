package com.edu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainAppProduct {
	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		config.addAnnotatedClass(Product.class);
		config.addAnnotatedClass(Customer.class);
		
	//	Configuration config = new Configuration()
	//			.configure("hibernate.cfg.xml")
	//			.addAnnotatedClass(Product.class);
		
		SessionFactory sf = config.buildSessionFactory();
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Product pob = new Product("Chairs",78000.5f); // Transient state
		Product pob1 = new Product("Washing Machine",40000.5f);
		Product pob2 = new Product("Fridge",68000.5f);
		session.save(pob); //Persistent state
		session.save(pob1);
		session.save(pob2);
		
		Customer cob = new Customer("Rahul","Satara");
		Customer cob1 = new Customer("Jay","Pune");
		Customer cob2 = new Customer("Rohan","Mumbai");
		session.save(cob);
		session.save(cob1);
		session.save(cob2);
		tx.commit();
		
		//session.evict(pob);
		//pob.setProductName("mobile");
		//tx.commit();
		//Product s = session.get(Product.class, 1);
		//System.out.println("from database product =" +s.toString());
		//session.delete(s); //removed state
		//tx.commit();
		session.close();
		
		
		
	}
}