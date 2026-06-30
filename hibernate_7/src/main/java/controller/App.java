package controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Acc;
import model.Emp;

public class App {
	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Acc a = new Acc();
		a.setAid(101);
		a.setLocation("pune");
		a.setType("Reg");
		session.persist(a);

		Acc a1 = new Acc();
		a1.setAid(102);
		a1.setLocation("satara");
		a1.setType("deposit");
		session.persist(a1);

//here we can simply created the array (dynamic)		
		List<Acc> li = new ArrayList<Acc>();
		li.add(a);
		li.add(a1);

		Emp e = new Emp();
		e.setEmpid(201);
		e.setName("shruti");
		e.setDesignation("Engineer");
		e.setLi(li);

		session.persist(e);

		tx.commit();
		session.close();

	}

}
