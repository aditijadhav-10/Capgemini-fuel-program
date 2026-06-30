package controller;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Department;
import model.Emplyee;

public class App {
	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Emplyee e = new Emplyee();
		e.setEid(10);
		e.setEname("Adi");
		e.setEadd("Satara");
		session.persist(e);

		ArrayList<Emplyee> lst = new ArrayList<>();
		lst.add(e);

		Department d = new Department();
		d.setDid(2);
		d.setDname("MCA");
		d.setE(lst);

		session.persist(d);
		tx.commit();
		session.close();

	}
}
