package ru.prokhorov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.prokhorov.entities.Basket;
import ru.prokhorov.repository.BasketRepository;

import java.util.Optional;

@Service
public class BasketService {
    private BasketRepository basketRepository;

    @Autowired
    public void setBasketRepository(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    public BasketService() {
    }

    public void addProductToBasket(Basket basket){
        basketRepository.save(basket);
    }

    public void deleteProductByIdFromBasket(long product_id){
        basketRepository.deleteProductById(product_id);
    }

    public Optional<Basket> getBasketToUserId(long user_id){
        return basketRepository.findByUserId(user_id);
    }
}
