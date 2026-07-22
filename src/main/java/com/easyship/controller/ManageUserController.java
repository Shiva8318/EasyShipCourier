package com.easyship.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.easyship.repository.UserRepository;

@Controller
public class ManageUserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/manageusers")
    public String manageUsers(Model model) {

        model.addAttribute("userList", userRepository.findAll());

        return "manageusers";
    }

}