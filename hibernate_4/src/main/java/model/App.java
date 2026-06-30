package model;

import java.util.Scanner;

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
		Transaction tx=session.beginTransaction();
		Department d=new Department();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the dep id:");
		int did = sc.nextInt();
		System.out.println("Enter the dep name :");
		String dname = sc.next();
		System.out.println("Enter the dep location :");
		String location = sc.next();

		System.out.println("Enter the Registration no :");
		int Reg_no = sc.nextInt();

		d.setDid(did);
		d.setDname(dname);
		d.setLocation(location);
		d.setReg_no(Reg_no);
		
		session.persist(d);
		tx.commit();
		session.close();
	
		
	}


}
