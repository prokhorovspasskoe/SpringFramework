package ru.prokhorov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.prokhorov.entities.Product;
import ru.prokhorov.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Optional<Product> getProductById(int id){
        return productRepository.findById(id);
    }

    public Product saveOrUpdate(Product product){
        return productRepository.save(product);
    }

    public void delete(int id){
        Optional<Product> product = productRepository.findById(id);
        productRepository.delete(product.get());
    }

    public List<Product> getAllProducts(){
        return (List<Product>) productRepository.findAll();
    }
}
