package ru.prokhorov.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.prokhorov.entities.Basket;

import java.util.Optional;

@Repository
public interface BasketRepository extends PagingAndSortingRepository<Basket, Long> {
    @Query(value = "DELETE FROM baskets WHERE product_id = ?1")
    void deleteProductById(long product_id);

    @Query(value = "SELECT product_id, title, price FROM basket WHERE user_id = ?1")
    Optional<Basket> findByUserId(long user_id);
}
