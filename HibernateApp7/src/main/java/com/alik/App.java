package com.alik;

import com.alik.model.Actor;
import com.alik.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {

        Configuration configuration = new Configuration().
                addAnnotatedClass(Actor.class).addAnnotatedClass(Movie.class);

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            // add movie and its actors to db
//            Movie movie = new Movie("first movie",1994);
//            Actor actor1 = new Actor("First actor", 85);
//            Actor actor2 = new Actor("Second actor", 50);
//            movie.setActors(new ArrayList<>(List.of(actor1,actor2)));
//            actor1.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//            actor2.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//            session.persist(movie);
//            session.persist(actor1);
//            session.persist(actor2);

// get actors of movie
//            Movie movie = session.get(Movie.class,2);
//            System.out.println(movie.getActors());

            //add movie to existing actor
//            Movie movie = new Movie("second movie",2000);
//            Actor actor = session.get(Actor.class,4);
//            movie.setActors(new ArrayList<>(Collections.singletonList(actor)));
//            actor.getMovies().add(movie);
//            session.persist(movie);


            Actor actor = session.get(Actor.class,4);
            System.out.println(actor.getMovies());

            Movie movie = actor.getMovies().get(0);

            actor.getMovies().remove(0);
            movie.getActors().remove(actor);


            session.getTransaction().commit();

        }


    }
}
