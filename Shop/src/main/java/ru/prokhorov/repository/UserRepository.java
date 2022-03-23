package ru.prokhorov.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.prokhorov.entities.User;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query(value = "SELECT id, password, email FROM users WHERE username = ?1")
    User findByName(String name);
}
