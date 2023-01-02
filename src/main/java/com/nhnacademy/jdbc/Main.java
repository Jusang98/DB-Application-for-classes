//package com.nhnacademy.jdbc;
//
//
//
//
//import com.nhnacademy.jdbc.config.MainConfig;
//import com.nhnacademy.jdbc.service.UserService;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//public class Main {
//    public static void main(String[] args) {
//        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class)) {
//            UserService userService = context.getBean(UserService.class);
//            System.out.println("==> All Students");
//            System.out.println(userService.getStudent(1L));
//
//
//        }
//    }
//}