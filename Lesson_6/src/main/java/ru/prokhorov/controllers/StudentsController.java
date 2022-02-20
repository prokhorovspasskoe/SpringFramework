package ru.prokhorov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.prokhorov.entities.Course;
import ru.prokhorov.service.StudentsService;
import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping("/students")
@Transactional
public class StudentsController {
    private StudentsService studentsService;

    @Autowired
    public void setStudentsService(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @RequestMapping(value = "/delete_student.jsp", method = RequestMethod.POST)
    public void deleteStudentById(@RequestParam("id") Long id){
        studentsService = new StudentsService();
        studentsService.deleteStudentById(id);
    }

    @RequestMapping(value = "/get_all_student_courses.jsp", method = RequestMethod.GET)
    public String getAllStudentCoursesById(Model model, Long id){
        studentsService = new StudentsService();
        List<Course> courses = studentsService.getAllStudentCoursesById(id);
        return "show_all_courses";
    }
}
