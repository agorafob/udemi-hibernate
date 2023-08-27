package com.alik;

import com.alik.model.Principal;
import com.alik.model.School;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {

        Configuration configuration = new Configuration().
                addAnnotatedClass(Principal.class).addAnnotatedClass(School.class);

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

//            Получите любую школу, а затем получите ее директора.
//            System.out.println(session.get(School.class,1));
//            System.out.println(session.get(School.class,2));
//            System.out.println(session.get(School.class,3));
//            System.out.println(session.get(School.class,4));

//           Создайте нового директора и новую школу и свяжите эти сущности.
//            Principal principal = new Principal("Alik", 35);
//            principal.setSchool(new School(999));
//            session.persist(principal);



//       Смените директора у существующей школы.
//            Principal principal = new Principal("Lera",34);
//            School school = session.get(School.class,6);
//            session.remove(school.getPrincipal());
//            principal.setSchool(school);
//            session.persist(principal);

//            Попробуйте добавить вторую школу для существующего директора и
//изучите возникающую ошибку.
            Principal principal =session.get(Principal.class,23);
            principal.setSchool(session.get(School.class,2));



            session.getTransaction().commit();

        }


    }
}
