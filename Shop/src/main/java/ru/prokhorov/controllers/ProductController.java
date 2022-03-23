package ru.prokhorov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.prokhorov.entities.Product;
import ru.prokhorov.service.ProductService;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping("/products")
@Transactional
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService){
        this.productService = productService;
    }

    @RequestMapping("/list")
    @Transactional
    public String showProductList(Model model){
        List<Product> productList = productService.getProductList();
        model.addAttribute("productList", productList);
        return "product-list";
    }
}
