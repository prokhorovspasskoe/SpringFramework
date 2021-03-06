package ru.prokhorov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.prokhorov.entities.Course;
import ru.prokhorov.entities.Student;
import ru.prokhorov.repository.StudentsRepository;

import java.util.List;

@Service
public class StudentsService {
    private StudentsRepository studentsRepository;
    private CoursesService coursesService;

    @Autowired
    public void setStudentsRepository(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    @Autowired
    public void setCoursesService(CoursesService coursesService) {
        this.coursesService = coursesService;
    }

    public StudentsService() {
    }

    public void deleteStudentById(Long id){
        studentsRepository.deleteById(id);
    }

    public List<Course> getAllStudentCoursesById(Long id){
        return studentsRepository.findOneById(id).getCourses();
    }
}
