package ru.prokhorov.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.prokhorov.entities.Student;

@Repository
public interface StudentsRepository extends PagingAndSortingRepository<Student, Long> {
    Student findOneById(Long id);

    void deleteById(Long id);
}
