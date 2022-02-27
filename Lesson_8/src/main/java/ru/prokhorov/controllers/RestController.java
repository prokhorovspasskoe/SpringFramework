package ru.prokhorov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.prokhorov.entities.Product;
import ru.prokhorov.service.ProductService;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/**")
@org.springframework.web.bind.annotation.RestController
public class RestController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/products/{productId}")
    public Optional<Product> getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PutMapping(path = "/products", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Product addProduct(@RequestBody Product product) {
        product = productService.saveOrUpdate(product);
        return product;
    }

    @DeleteMapping("/products/{productId}")
    public int deleteStudent(@PathVariable int id) {
        productService.delete(id);
        return HttpStatus.OK.value();
    }
}
