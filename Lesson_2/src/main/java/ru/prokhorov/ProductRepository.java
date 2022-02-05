package ru.prokhorov;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private List<Product> listProduct;

    public ProductRepository(){
        listProduct = new ArrayList<Product>();
    }

    public Product getProduct(int id){
        return listProduct.get(id);
    }

    public List<Product> getAllProduct(){
        return listProduct;
    }

    public void setProduct(Product product){
        listProduct.add(product);
    }
}
