package com.alik;

import com.alik.model.Passport;
import com.alik.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {

        Configuration configuration = new Configuration().
                addAnnotatedClass(Person.class).addAnnotatedClass(Passport.class);

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            //create new person , set new passport, persist to db
//            Person person = new Person("test person",50);
//            person.setPassport(new Passport(123456));
//            session.persist(person);

            //get person from db and get its passport number
//            Person person = session.get(Person.class,1);
//            System.out.println(person.getPassport().getPassport_number());

            //get passport from db and get its owner
//            System.out.println(session.get(Passport.class,2));

            // get person and set new passport number WITHOUT .persist()
//            session.get(Person.class,1).getPassport().setPassport_number(564321);

//                delete person and passport cascade
//            Person person = session.get(Person.class,1);
//            session.remove(person);
//            same but in 1 line
//            session.remove(session.get(Person.class,2));


            session.getTransaction().commit();

        }


    }
}
