package ru.prokhorov.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.prokhorov.entities.Role;

public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {
}
