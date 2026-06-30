package controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Account;
import model.Emp;

public class App {
	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure();

		SessionFactory sessionFactory = config.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Emp e=new Emp();
		e.setEid(101);
		e.setName("Adi");
		e.setDesignation("bds");
		
		Account a=new Account();
		a.setAccid(201);
		a.setAcctype("de");
		a.setEmp(e);
		
		session.persist(e);
		tx.commit();
		session.close();
	

	}

}
