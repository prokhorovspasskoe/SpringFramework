package ru.prokhorov.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.prokhorov.entities.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
}
