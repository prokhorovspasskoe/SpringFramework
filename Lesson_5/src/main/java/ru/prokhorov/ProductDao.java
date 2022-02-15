package ru.prokhorov;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDao {

    public Product findById(int id, Session session){
        Product product = null;
        try{
            session.beginTransaction();
            product = session.get(Product.class, id);
            System.out.println(product.getTitle());
        }finally {
            assert session != null;
            session.close();
        }
        return product;
    }

    public List<Product> findAll(Session session){
        List<Product> productList;
        try {
            session.beginTransaction();
            productList = session.createQuery("FROM products", Product.class).getResultList();
            System.out.println(productList.toString());
        }finally {
            assert session != null;
            session.close();
        }
        return productList;
    }

    public void deleteById(int id, Session session){
        Product product;
        try {
            session.beginTransaction();
            product = session.get(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();
        }finally {
            assert session != null;
            session.close();
        }
    }

    public Product saveOrUpdate(Product product, Session session){
        try {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }finally {
            assert session != null;
            session.close();
        }
        return product;
    }
}
