package ru.prokhorov;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDao {

    private final SessionFactory sessionFactory;
    private final Session session;

    public ProductDao() {
        this.sessionFactory = new Configuration().
                configure("hibernate_config.xml").
                addAnnotatedClass(Product.class).
                buildSessionFactory();
        session = sessionFactory.getCurrentSession();
    }

    public Product findById(int id){
        Product product = null;
        session.beginTransaction();
        product = session.get(Product.class, id);
        session.getTransaction().commit();
        return product;
    }

    public List<Product> findAll(){
        List<Product> productList;
        session.beginTransaction();
        productList = session.createQuery("FROM products", Product.class).getResultList();
        session.getTransaction().commit();
        return productList;
    }

    public void deleteById(int id, Session session){
        Product product;
        session.beginTransaction();
        product = session.get(Product.class, id);
        session.delete(product);
        session.getTransaction().commit();
    }

    public Product saveOrUpdate(Product product){
        session.beginTransaction();
        session.saveOrUpdate(product);
        session.getTransaction().commit();
        return product;
    }

    public void closeSessionAndFactory() {
        assert session != null;
        session.close();
        sessionFactory.close();
    }
}
