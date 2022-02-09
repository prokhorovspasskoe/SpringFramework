package ru.prokhorov;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private final List<Product> productList;

    public ProductRepository() {
        this.productList = new ArrayList<Product>();
    }

    public void setProduct(Product product){
        productList.add(product);
    }

    public List<Product> getListProduct(){
        return productList;
    }

    public Product getProduct(int id){
        return productList.get(id);
    }
}
