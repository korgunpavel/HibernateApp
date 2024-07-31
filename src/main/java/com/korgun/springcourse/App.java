package com.korgun.springcourse;

import com.korgun.springcourse.model.Item;
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
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);

        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Person person = session.get(Person.class, 4);
            Item item = session.get(Item.class, 1);
            item.getOwner().getItems().remove(item);

            item.setOwner(person);
            person.getItems().add(item);

            session.getTransaction().commit();
        }
    }
}
