package com.nhnacademy.jdbc.repository;


import com.nhnacademy.jdbc.domain.User;

public interface UserRepository {
    User findById(String name);
    boolean matches(String name, String pwd);

}
