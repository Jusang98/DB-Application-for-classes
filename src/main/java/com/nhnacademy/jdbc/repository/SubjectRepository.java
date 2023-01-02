package com.nhnacademy.jdbc.repository;

import com.nhnacademy.jdbc.domain.Subject;
import com.nhnacademy.jdbc.domain.Teacher;

import java.util.List;

public interface SubjectRepository {
    Subject findById(long id);

    List<Subject> findAll();

    int insert(Subject subject);

    int deleteById(long id);
}
