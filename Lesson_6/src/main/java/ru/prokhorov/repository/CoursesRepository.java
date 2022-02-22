package ru.prokhorov.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.prokhorov.entities.Course;

@Repository
public interface CoursesRepository extends CrudRepository<Course, Long> {
}
