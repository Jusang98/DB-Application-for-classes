package com.nhnacademy.jdbc.domain;

import javax.validation.constraints.NotBlank;

public class CourseModifyRequest {
    @NotBlank
    Long courseId;

    @NotBlank
    Long teacherId;

    @NotBlank
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

    public CourseModifyRequest() {
    }
}
