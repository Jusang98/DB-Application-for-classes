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
import java.util.Objects;

@Controller
@RequestMapping("/course")
public class CourseModifyController {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    private final SubjectRepository subjectRepository;

    public CourseModifyController(CourseRepository courseRepository, TeacherRepository teacherRepository, SubjectRepository subjectRepository) {
        this.courseRepository = courseRepository;
        this.teacherRepository = teacherRepository;
        this.subjectRepository = subjectRepository;
    }

    @ModelAttribute("course")
    public Course getStudent(@PathVariable(value = "courseId", required = false) Long courseId) {
        if (Objects.isNull(courseId)) {
            throw new RuntimeException();
        }
        return courseRepository.findById(courseId);
    }

    @GetMapping("/{courseId}/modify")
    public String courseModifyForm(@ModelAttribute Course course, ModelMap modelMap) {
        modelMap.put("course", course);
        return "thymeleaf/courseModify";
    }

    @PostMapping("/{courseId}/modify")
    public String modifyStudent(@ModelAttribute Course course,
                                @Valid @ModelAttribute CourseRegisterRequest courseRegisterRequest,
                                Model model) {
        course.setTeacher(teacherRepository.findById(courseRegisterRequest.getTeacherId()));
        course.setSubject(subjectRepository.findById(courseRegisterRequest.getSubjectId()));
        course.setCreatedAt(new Date());

        courseRepository.update(course);

        model.addAttribute("course", course);
        return "thymeleaf/courseView";
    }

    @GetMapping("/{courseId}/delete")
    public String courseDeleteForm(@ModelAttribute Course course, ModelMap modelMap) {
        modelMap.remove(course);
        courseRepository.deleteById(course.getId());
        return "redirect:/courseList";
    }
}
