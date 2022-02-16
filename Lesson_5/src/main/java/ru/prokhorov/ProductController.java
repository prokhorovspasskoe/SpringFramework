package ru.prokhorov;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    @RequestMapping(value = "/show-by-id", method = RequestMethod.GET)
    public String showProductById(Model model, @RequestParam int id){
        ProductDao productDao = new ProductDao();
        Product product = productDao.findById(id);
        model.addAttribute("name", product.getTitle());
        model.addAttribute("price", product.getPrice());
        productDao.closeSessionAndFactory();
        return "showproduct";
    }
}
