package com.alik;

import com.alik.model.Item;
import com.alik.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {

        Configuration configuration = new Configuration().
                addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            Person person = new Person("Test cascading2",30);
            person.addItem(new Item("test cascading item1"));
            person.addItem(new Item("test cascading item2"));
            person.addItem(new Item("test cascading item3"));
            session.persist(person);


            session.getTransaction().commit();

        }


    }
}
