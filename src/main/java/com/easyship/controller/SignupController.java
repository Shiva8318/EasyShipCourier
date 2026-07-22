package com.easyship.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.easyship.entity.User;
import com.easyship.service.UserService;

@Controller
public class SignupController {

    @Autowired
    private UserService service;

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/signup")
    public String register(User user) {

        service.registerUser(user);

        return "redirect:/login";

    }

}