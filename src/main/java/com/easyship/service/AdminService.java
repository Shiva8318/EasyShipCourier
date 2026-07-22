package com.easyship.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyship.entity.Admin;
import com.easyship.repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository repository;

    public Admin login(String email, String password) {

        return repository.findByEmailAndPassword(email, password);

    }

}