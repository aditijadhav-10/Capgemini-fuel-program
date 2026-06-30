package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		Configuration config= new Configuration();
		config.configure();
		
		SessionFactory sessionFactory=config.buildSessionFactory();
		
		Session session=sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		Teacher t=new Teacher();
		t.setTid(101);
		t.setName("Adsul");
		t.setAddress("baramati");
		t.setSalary(20000.00);
		
		session.persist(t);
		tx.commit();
		session.close();
	}

}
