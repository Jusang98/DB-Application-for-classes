package com.nhnacademy.jdbc.repository;


import com.nhnacademy.jdbc.domain.Course;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepositoryImpl implements CourseRepository {

    private final JdbcTemplate jdbcTemplate;

    private final TeacherRepository teacherRepository;
    private final SubjectRepository subjectRepository;


    public CourseRepositoryImpl(DataSource dataSource, TeacherRepository teacherRepository, SubjectRepository subjectRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.teacherRepository = teacherRepository;
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Course findById(long id) {
        return jdbcTemplate.queryForObject(
                "select id,teacher_id,subject_id, created_at from JdbcCourses  where id = ?",
                (resultSet, rowNum) ->
                        new Course(resultSet.getLong("id"),
                                teacherRepository.findById(resultSet.getLong("teacher_id")),
                                subjectRepository.findById(resultSet.getLong("subject_id")),
                                resultSet.getTimestamp("created_at")),
                id);

    }


    @Override
    public List<Course> findAll() {
        return jdbcTemplate.query(
                "select id, teacher_id,subject_id, created_at, created_at from JdbcCourses",
                (resultSet, rowNum) ->
                        new Course(resultSet.getLong("id"),
                                teacherRepository.findById(resultSet.getLong("teacher_id")),
                                subjectRepository.findById(resultSet.getLong("subject_id")),
                                resultSet.getTimestamp("created_at")));
    }

    @Override
    public int insert(Course course) {
        return jdbcTemplate.update(
                "INSERT INTO JdbcCourses(id, teacher_id,subject_id, created_at) VALUES (?,?,?,?)",
                course.getId(),
                course.getTeacher().getId(),
                course.getSubject().getId(),
                course.getCreatedAt()
        );

    }

    //    "UPDATE JdbcStudents SET name='학생3' WHERE id=2"
    @Override
    public int update(Course course) {
        return jdbcTemplate.update(
                "UPDATE JdbcCourses SET teacher_id=?,subject_id=?, created_at=? where id =?",
                course.getTeacher().getId(),
                course.getSubject().getId(),
                course.getCreatedAt(),course.getId()
        );
    }

    @Override
    public int deleteById(long id) {
        return jdbcTemplate.update(
                "DELETE FROM JdbcCourses WHERE id=?",
                id
        );
    }
}
