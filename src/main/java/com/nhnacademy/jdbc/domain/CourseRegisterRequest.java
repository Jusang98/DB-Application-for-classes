package com.nhnacademy.jdbc.domain;


import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class CourseRegisterRequest {


    Long courseId;


    Long teacherId;


    Long subjectId;

    public Long getCourseId() {
        return courseId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public CourseRegisterRequest() {
    }

}

