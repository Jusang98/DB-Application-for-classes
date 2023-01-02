package com.nhnacademy.jdbc.repository;


import com.nhnacademy.jdbc.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Optional;


@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public User findById(String name) {
        return jdbcTemplate.queryForObject(
                "select user_id, user_name, user_pwd from Users  where user_name = ?",
                (resultSet, rowNum) ->
                        new User(resultSet.getLong("user_id"),
                                resultSet.getString("user_name"),
                                resultSet.getString("user_pwd")),
                name);
    }


    @Override
    public boolean matches(String name, String pwd) {
        return Optional.ofNullable(findById(name))
                .map(user -> user.getPwd().equals(pwd))
                .orElse(false);
    }


}
