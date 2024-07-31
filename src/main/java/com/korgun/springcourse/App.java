package com.korgun.springcourse;

import com.korgun.springcourse.model.Director;
import com.korgun.springcourse.model.Item;
import com.korgun.springcourse.model.Movie;
import com.korgun.springcourse.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App 
{
    public static void main( String[] args ) {
        Configuration configuration = new Configuration().addAnnotatedClass(Director.class)
                .addAnnotatedClass(Movie.class);
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Director director = session.get(Director.class, 1);

            Movie movie = session.get(Movie.class, 4);

            director.getMovies().remove(movie);
            session.remove(movie);

            session.getTransaction().commit();
        }
    }
}
