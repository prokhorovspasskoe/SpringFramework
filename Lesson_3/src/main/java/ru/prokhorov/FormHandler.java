package ru.prokhorov;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormHandler {
    private  ProductRepository productRepository;
    @RequestMapping(value = "/addproductform.jsp", method = RequestMethod.POST)
    public void processForm(@RequestParam("id") int id,
                            @RequestParam("title") String title,
                            @RequestParam("cost") String cost){
        Product product = new Product(id, title, cost);
        productRepository = new ProductRepository();
        productRepository.setProduct(product);
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showlistProduct(Model model){
        model.addAttribute("product", productRepository);
        return "showlistproduct";
    }
}
