package com.easyship.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyship.entity.User;
import com.easyship.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User registerUser(User user) {

        return repo.save(user);

    }
    public User loginUser(String email, String password) {

        return repo.findByEmailAndPassword(email, password);

    }

}