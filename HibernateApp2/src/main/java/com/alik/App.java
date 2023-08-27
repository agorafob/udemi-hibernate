package com.alik;

import com.alik.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();
//        Person person1 = new Person("alik",35);
//        Person person2 = new Person("lera",30);
//        Person person3 = new Person("una",3);
//
//        session.persist(person1);
//        session.persist(person2);
//        session.persist(person3);

//        Person person = session.get(Person.class,2);
//        person.setName("VALERA");

//        Person person = session.get(Person.class,2);
//        session.remove(person);

        Person person2 = new Person("lera",30);
        session.persist(person2);

        session.getTransaction().commit();

        System.out.println(person2.getId());

        sessionFactory.close();

    }
}
