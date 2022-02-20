package ru.prokhorov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.prokhorov.repository.CoursesRepository;


@Service
public class CoursesService {
    private CoursesRepository coursesRepository;

    @Autowired
    public void setCoursesRepository(CoursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
    }
}
