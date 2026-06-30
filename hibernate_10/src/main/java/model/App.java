package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {

		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = config.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Student s1 = new Student(101, "Aditi");
		Student s2 = new Student(102, "Shruti");

		Course c1 = new Course(1, "java");
		Course c2 = new Course(2, "python");

		s1.getC().add(c1);
		s1.getC().add(c2);

		s2.getC().add(c1);

		session.persist(s1);
		session.persist(s2);

		session.persist(c1);
		session.persist(c2);

		tx.commit();
		session.close();

		System.out.println("data saved successfully");
	}

}
