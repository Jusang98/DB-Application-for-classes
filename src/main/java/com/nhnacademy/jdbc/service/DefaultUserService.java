package com.nhnacademy.jdbc.service;


import com.nhnacademy.jdbc.domain.User;
import com.nhnacademy.jdbc.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class DefaultUserService implements UserService {
    private final UserRepository userRepository;

    public DefaultUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    @Transactional
    public User getStudent(String name) {
        return userRepository.findById(name);
    }


}
