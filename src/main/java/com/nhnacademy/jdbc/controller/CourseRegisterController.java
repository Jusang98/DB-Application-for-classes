package com.nhnacademy.jdbc.controller;


import com.nhnacademy.jdbc.domain.Course;
import com.nhnacademy.jdbc.domain.CourseRegisterRequest;
import com.nhnacademy.jdbc.repository.CourseRepository;
import com.nhnacademy.jdbc.repository.SubjectRepository;
import com.nhnacademy.jdbc.repository.TeacherRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Date;

@Controller
@RequestMapping("/register")
public class CourseRegisterController {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    private final SubjectRepository subjectRepository;

    public CourseRegisterController(CourseRepository courseRepository, TeacherRepository teacherRepository, SubjectRepository subjectRepository) {
        this.courseRepository = courseRepository;
        this.teacherRepository = teacherRepository;
        this.subjectRepository = subjectRepository;
    }

    @GetMapping
    public String PostRegisterForm() {
        return "thymeleaf/courseRegister";
    }

    @PostMapping
    public ModelAndView registerPost(@ModelAttribute CourseRegisterRequest courseRegisterRequest,
                                     Model model) throws IOException {

        Course course = courseRepository.findById(courseRepository.insert(new Course(courseRegisterRequest.getCourseId(),
                teacherRepository.findById(courseRegisterRequest.getTeacherId()),
                subjectRepository.findById(courseRegisterRequest.getSubjectId()),
                new Date())));


        ModelAndView mav = new ModelAndView("redirect:/courseList");

        mav.addObject("course", course);

        return mav;
    }
}
