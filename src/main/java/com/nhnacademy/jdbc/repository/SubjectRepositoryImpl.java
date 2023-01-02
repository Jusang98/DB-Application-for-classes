package com.nhnacademy.jdbc.repository;

import com.nhnacademy.jdbc.domain.Subject;
import com.nhnacademy.jdbc.domain.Teacher;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class SubjectRepositoryImpl implements SubjectRepository {
    private final JdbcTemplate jdbcTemplate;

    public SubjectRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Subject findById(long id) {
        return jdbcTemplate.queryForObject(
                "select id, name, created_at from JdbcSubjects  where id = ?",
                (resultSet, rowNum) ->
                        new Subject(resultSet.getLong("id"),
                                resultSet.getString("name"),
                                resultSet.getTimestamp("created_at")),
                id);
    }

    @Override
    public List<Subject> findAll() {
        return jdbcTemplate.query(
                "select id, name, created_at from JdbcSubjects",
                (resultSet, rowNum) ->
                        new Subject(resultSet.getLong("id"),
                                resultSet.getString("name"),
                                resultSet.getTimestamp("created_at")));
    }

    @Override
    public int insert(Subject subject) {
        return jdbcTemplate.update(
                "INSERT INTO JdbcSubjects(id, name, created_at) VALUES (?,?,?)",
                subject.getId(),
                subject.getName(),
                subject.getCreateAt()
        );
    }

    @Override
    public int deleteById(long id) {
        return jdbcTemplate.update(
                "DELETE FROM JdbcSubjects WHERE id=?",
                id
        );
    }
}
