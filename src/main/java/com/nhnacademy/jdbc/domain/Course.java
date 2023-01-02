package com.nhnacademy.jdbc.domain;

import com.nhnacademy.jdbc.domain.Subject;
import com.nhnacademy.jdbc.domain.Teacher;

import java.util.Date;

public class Course {

    private Long id;
    private Subject subject;
    private Teacher teacher;
    private Date createdAt;

    public Course(Long id, Teacher teacher, Subject subject, Date createdAt) {
        this.id = id;
        this.subject = subject;
        this.teacher = teacher;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public Subject getSubject() {
        return subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", subject=" + subject +
                ", teacher=" + teacher +
                ", createdAt=" + createdAt +
                '}';
    }
}