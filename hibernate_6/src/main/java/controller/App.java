
package controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Locker;
import model.Person;

public class App {
	public static void main(String[] args) {
		Configuration config=new Configuration();
		config.configure();
		
		SessionFactory sessionFactory =config.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		Person p=new  Person();
		p.setPname("Adi");
		p.setPid(102);
		p.setAddress("dahi");
		p.setAge(21);
		
		Locker l=new Locker();
		l.setLid(210);
		l.setLocation("pune");
		l.setPerson(p);
		
		session.persist(p);
		tx.commit();
		session.close();
		
	}
}
