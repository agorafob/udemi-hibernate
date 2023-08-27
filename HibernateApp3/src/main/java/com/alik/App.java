package com.alik;

import com.alik.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();


//        List<Person> people = session.createQuery("from Person where name like 'a%'").getResultList();
//        for (Person p: people ) {
//            System.out.println(p);
//        }

        session.createQuery("delete Person where age<30").executeUpdate();
        session.getTransaction().commit();

        sessionFactory.close();

    }
}
