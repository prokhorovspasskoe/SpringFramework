package ru.prokhorov;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext("ru/prokhorov");

        Session session = null;

        SessionFactory sessionFactory = context.getBean(new Configuration().
                configure("hibernate_config.xml").
                addAnnotatedClass(Product.class).
                buildSessionFactory().getClass());

    }
}
