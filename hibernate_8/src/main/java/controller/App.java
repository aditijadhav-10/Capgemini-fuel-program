package controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Course;
import model.Student;

public class App {

    public static void main(String[] args) {

        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();

        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Student s1 = new Student("Pradeep");
        Student s2 = new Student("Rahul");

        Course c1 = new Course("Java");
        Course c2 = new Course("Python");
        Course c3 = new Course("SQL");

        s1.getCourses().add(c1);
        s1.getCourses().add(c2);

        s2.getCourses().add(c1);
        s2.getCourses().add(c3);

        session.persist(s1);
        session.persist(s2);

        tx.commit();

        session.close();
        sf.close();

        System.out.println("Many-to-Many Data Inserted Successfully...");
    }
}