package com.alik;

import com.alik.model.Director;
import com.alik.model.Movie;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {

        Configuration configuration = new Configuration().
                addAnnotatedClass(Director.class).addAnnotatedClass(Movie.class);

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

//            получите любого режиссера, а затем получите список его фильмов.
//            Director director=session.get(Director.class,1);
//            System.out.println(director);
//            System.out.println(director.getMovies());

//            Получите любой фильм, а затем получите его режиссера.
//            Movie movie = session.get(Movie.class,6);
//            System.out.println(movie);
//            System.out.println(movie.getDirector());

//Добавьте еще один фильм для любого режиссера.
//            Director director=session.get(Director.class,6);
//            System.out.println(director);
//            System.out.println(director.getMovies());
//            System.out.println("add movie");
//            director.addMovie(new Movie("Dark Knight",2010));
//            session.persist(director);
//            System.out.println(director.getMovies());

//          Создайте нового режиссера и новый фильм и свяжите эти сущности.
//            Director director = new Director("James Gunn", 50);
//            director.addMovie(new Movie("Got", 2014));
//            director.addMovie(new Movie("Got2", 2018));
//            director.addMovie(new Movie("Got3", 2023));
//            session.persist(director);

//            Смените режиссера у существующего фильма.
//           новый
//            Movie movie = session.get(Movie.class,16);
//            Director director = new Director("Test test",44);
//            movie.setDirector(director);
//            session.persist(director);
//          уже имеющийся в бд
//            session.get(Movie.class,16).setDirector(session.get(Director.class,7));
//
//            Удалите фильм у любого режиссера.
            Director d = session.get(Director.class,7);
           session.remove(d.getMovies().get(0));






            session.getTransaction().commit();

        }


    }
}
