package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure();

		SessionFactory sessionfactory = config.buildSessionFactory();
		Session session = sessionfactory.openSession();

		Transaction tx = session.beginTransaction();
		Student s = new Student();
		s.setId(101);
		s.setName("Adi");
		s.setAddress("Satara");
		session.persist(s);
		tx.commit();
		session.close();
	}

}
