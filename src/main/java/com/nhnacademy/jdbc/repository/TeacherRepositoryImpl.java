package com.nhnacademy.jdbc.repository;

import com.nhnacademy.jdbc.domain.Teacher;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class TeacherRepositoryImpl implements TeacherRepository {

    private final JdbcTemplate jdbcTemplate;

    public TeacherRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Teacher findById(long id) {
        return jdbcTemplate.queryForObject(
                "select id, name, created_at from JdbcTeachers  where id = ?",
                (resultSet, rowNum) ->
                        new Teacher(resultSet.getLong("id"),
                                resultSet.getString("name"),
                                resultSet.getTimestamp("created_at")),
                id);
    }

    @Override
    public List<Teacher> findAll() {
        return jdbcTemplate.query(
                "select id, name, created_at from JdbcTeachers",
                (resultSet, rowNum) ->
                        new Teacher(resultSet.getLong("id"),
                                resultSet.getString("name"),
                                resultSet.getTimestamp("created_at")));
    }

    @Override
    public int insert(Teacher teacher) {
        return jdbcTemplate.update(
                "INSERT INTO JdbcTeachers(id, name, created_at) VALUES (?,?,?)",
                teacher.getId(),
                teacher.getName(),
                teacher.getCreateAt()
        );
    }

    @Override
    public int deleteById(long id) {
        return jdbcTemplate.update(
                "DELETE FROM JdbcTeachers WHERE id=?",
                id
        );
    }
}
