package ru.prokhorov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.prokhorov.entities.Product;
import ru.prokhorov.services.ProductServices;

import java.util.List;

@Controller
@RequestMapping("/products")
public class RestController {
    private ProductServices productServices;

    @Autowired
    public void setProductService(ProductServices productServices){
        this.productServices = productServices;
    }

    @RequestMapping("/list")
    public String showProductList(Model model){
        List<Product> allProducts = productServices.getAllProducts();
        model.addAttribute("productsList", allProducts);
        return "product-list";
    }

    @RequestMapping(path="/add", method= RequestMethod.GET)
    public String showAddProduct(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "add-product";
    }

    @RequestMapping(path="/add", method=RequestMethod.POST)
    public String showAddForm(Product product){
        productServices.addNewProduct(product);
        return "redirect:/list";
    }

    @RequestMapping(path="/remove/{id}", method=RequestMethod.GET)
    public String removeProductById(@PathVariable(value = "id") int id){
        productServices.deleteProductById(id);
        return "redirect:/list";
    }
}
