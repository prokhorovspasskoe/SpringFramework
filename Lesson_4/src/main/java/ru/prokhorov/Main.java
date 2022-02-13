package ru.prokhorov;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate_config.xml").
                addAnnotatedClass(Product.class).
                addAnnotatedClass(Category.class).
                buildSessionFactory();

        Session session = null;
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Product product = session.get(Product.class, 1);
        System.out.println(product.getTitle());
        session.close();
    }
}
