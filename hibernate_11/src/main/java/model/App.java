package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		Configuration config=new Configuration();
		config.configure();
		
		SessionFactory sessionFactory=config.buildSessionFactory();
		
		Session session=sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		
		Customer c1=new Customer(101,"Aditi","Dahiwadi");
		Customer c2=new Customer(102,"shruti","pune");
		
		Product p1=new Product(201,"keyboard",2000);
		Product p2=new Product(202, "mouse",500);
		
		c1.getP().add(p1);
		c2.getP().add(p2);
		
		c1.getP().add(p2);
		
		session.persist(c1);
		session.persist(c2);
		session.persist(p1);
		session.persist(p2);
		
		tx.commit();
		session.close();
		System.out.println("Data inserted successfully");
		
		
		
	}
}
