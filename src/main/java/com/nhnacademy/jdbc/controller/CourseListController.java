package com.nhnacademy.jdbc.controller;


import com.nhnacademy.jdbc.domain.Course;
import com.nhnacademy.jdbc.domain.CourseRegisterRequest;
import com.nhnacademy.jdbc.repository.CourseRepository;
import com.nhnacademy.jdbc.repository.SubjectRepository;
import com.nhnacademy.jdbc.repository.TeacherRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;


@Controller
@RequestMapping("/courseList")
public class CourseListController {
    private final CourseRepository courseRepository;


    public CourseListController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;

    }


    @GetMapping
    public String CourseList(Model model) {
        model.addAttribute("courseList", courseRepository.findAll());
        return "thymeleaf/courseList";
    }
}
