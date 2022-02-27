package ru.prokhorov.services;

import ru.prokhorov.entities.Product;
import ru.prokhorov.repositiry.ProductRepository;

import java.util.List;
import java.util.Optional;

public class ProductServices {
    private ProductRepository productRepository;

    public Optional<Product> getProductById(int id){
        return productRepository.findById(id);
    }

    public List<Product> getAllProducts(){
        return (List<Product>) productRepository.findAll();
    }

    public void addNewProduct(Product product){
        productRepository.save(product);
    }

    public void deleteProductById(int id){
        productRepository.deleteById(id);
    }
}
