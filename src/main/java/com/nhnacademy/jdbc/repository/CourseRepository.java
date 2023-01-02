package com.nhnacademy.jdbc.repository;

import com.nhnacademy.jdbc.domain.Course;

import java.sql.Connection;
import java.util.List;

public interface CourseRepository {
    List<Course> findAll();

    Course findById(long id);

    int update(Course course);

    int insert(Course course);

    int deleteById(long id);
}
