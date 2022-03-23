package ru.prokhorov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.prokhorov.entities.Basket;
import ru.prokhorov.entities.Product;
import ru.prokhorov.entities.User;
import ru.prokhorov.service.BasketService;

import javax.transaction.Transactional;
import java.util.Optional;

@Controller
@RequestMapping("/products")
@Transactional
public class BasketController {
    private BasketService basketService;

    @Autowired
    public void setBasketService(BasketService basketService) {
        this.basketService = basketService;
    }

    @RequestMapping(path = "/list", method = RequestMethod.POST)
    public void addProductToBasket(Product product, User user){
        Basket basket = new Basket();
        basket.setProduct_id(product.getId());
        basket.setId_user(user.getId());
        basket.setPrice(product.getPrice());
        basket.setTitle(product.getTitle());
        basketService.addProductToBasket(basket);
    }

    @RequestMapping(path = "/basket", method = RequestMethod.GET)
    public String getBasket(Model model){
        Optional<Basket> basket = basketService.getBasketToUserId(0);
        model.addAttribute("basket", basket);
        return "basket";
    }
}
