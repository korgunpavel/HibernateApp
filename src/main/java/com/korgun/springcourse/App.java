package com.korgun.springcourse;

import com.korgun.springcourse.model.Actor;
import com.korgun.springcourse.model.Item;
import com.korgun.springcourse.model.Movie;
import com.korgun.springcourse.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class App 
{
    public static void main( String[] args ) {
        Configuration configuration = new Configuration().addAnnotatedClass(Actor.class).addAnnotatedClass(Movie.class);

        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Actor actor = session.get(Actor.class,2);
            System.out.println(actor.getMovies());

            Movie movieRemove = actor.getMovies().get(0);

            actor.getMovies().remove(movieRemove);
            movieRemove.getActors().remove(actor);



            session.getTransaction().commit();
        }
    }
}
