package com.easyship.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.servlet.http.HttpSession;

import com.easyship.entity.User;
import com.easyship.service.UserService;

@Controller
public class LoginController {

    @Autowired
    private UserService service;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(String email,
                        String password,
                        HttpSession session) {

        User user = service.loginUser(email, password);

        if (user != null) {

            session.setAttribute("loggedUser", user);

            return "redirect:/dashboard";

        }

        return "redirect:/login";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();

        return "redirect:/login";

    }
    }

