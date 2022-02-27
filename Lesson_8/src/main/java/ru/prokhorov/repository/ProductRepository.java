package ru.prokhorov.repository;

import org.springframework.data.repository.CrudRepository;
import ru.prokhorov.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
