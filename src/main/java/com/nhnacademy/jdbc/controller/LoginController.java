package com.nhnacademy.jdbc.controller;


import com.nhnacademy.jdbc.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class LoginController {
    private final UserRepository userRepository;


    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String login(HttpServletRequest req) {
        HttpSession session = req.getSession();
        if (session.getAttribute("userLogin") != null) {
            session.setAttribute("id", session);
            return "redirect:/courseList";
        } else {
            return "thymeleaf/loginForm";
        }
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam("id") String name,
                          @RequestParam("pwd") String pwd,
                          HttpServletRequest request
    ) {
        HttpSession session = request.getSession(true);
        if (userRepository.matches(name, pwd)) {
            session.setAttribute("userLogin", name);
            return "redirect:/courseList";
        } else {
            return "redirect:/login";
        }
    }


}
