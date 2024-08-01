package com.korgun.springcourse;

import com.korgun.springcourse.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App 
{
    public static void main( String[] args ) {
        Configuration configuration = new Configuration().addAnnotatedClass(Principal.class).addAnnotatedClass(School.class);

        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            School school = session.get(School.class,4);
            Principal principal = session.get(Principal.class,2);



            session.getTransaction().commit();
        }
    }
}
