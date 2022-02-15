package ru.prokhorov;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Component
@Entity
@Table(name = "products")
public class ProductDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private int price;

    private SessionFactory sessionFactory;
    private Session session;

    public ProductDao() {
        sessionFactory = new Configuration().
                configure("hibernate_config.xml").
                addAnnotatedClass(Product.class).
                buildSessionFactory();
        session = null;
    }

    public Product findById(int id){
        Product product;
        try{
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            product = session.get(Product.class, id);
        }finally {
            assert session != null;
            session.close();
            sessionFactory.close();
        }
        return product;
    }

    public List<Product> findAll(){
        List<Product> productList;
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            productList = session.createQuery("FROM products", Product.class).getResultList();
        }finally {
            assert session != null;
            session.close();
            sessionFactory.close();
        }

        return productList;
    }

    public void deleteById(int id){
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("DELETE FROM products WHERE id = " + id, Product.class).executeUpdate();
            session.getTransaction().commit();
        }finally {
            assert session != null;
            session.close();
            sessionFactory.close();
        }
    }

    public Product saveOrUpdate(Product product){
        return null;
    }
}
