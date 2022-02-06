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
        pw.println("<HTML><BODY>" + getAllProduct(productRepository)+ "</BODY></HTML>");
    }

    public List<Product> getAllProduct(ProductRepository productRepository){
        return productRepository.getAllProduct();
    }
}
