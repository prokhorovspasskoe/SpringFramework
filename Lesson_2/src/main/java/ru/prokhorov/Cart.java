package ru.prokhorov;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Integer> productId;

    public Cart(){
        productId = new ArrayList<Integer>();
    }

    public void addProductId(Integer id){
        productId.add(id);
    }

    public void deleteProductId(Integer id){
        productId.remove(id);
    }
}
