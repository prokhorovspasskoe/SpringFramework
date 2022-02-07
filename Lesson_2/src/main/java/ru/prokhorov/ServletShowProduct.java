package ru.prokhorov;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ServletShowProduct extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws IOException {
        httpServletResponse.setContentType("text/html");
        PrintWriter pw = httpServletResponse.getWriter();
        ProductRepository productRepository = new ProductRepository();
        Product bread = new Product(1,"bread", 32.45);
        Product potato = new Product(2, "potato", 23.65);
        Product tea = new Product(3, "tea", 54.18);
        Product sugar = new Product(4, "sugar", 29.60);
        Product rice = new Product(5, "rice", 32.75);
        Product buckwheat = new Product(6, "buckwheat", 28.90);
        Product flour = new Product(7, "flour", 34.99);
        Product carrot = new Product(8, "carrot", 18.30);
        Product beer = new Product(9, "beer", 9.99);
        Product vodka = new Product(10, "vodka", 7.99);

        productRepository.setProduct(bread);
        productRepository.setProduct(potato);
        productRepository.setProduct(tea);
        productRepository.setProduct(sugar);
        productRepository.setProduct(rice);
        productRepository.setProduct(buckwheat);
        productRepository.setProduct(flour);
        productRepository.setProduct(carrot);
        productRepository.setProduct(beer);
        productRepository.setProduct(vodka);

        pw.println("<HTML><BODY>" + getAllProduct(productRepository)+ "</BODY></HTML>");
    }

    public List<Product> getAllProduct(ProductRepository productRepository){
        return productRepository.getAllProduct();
    }
}
