package com.easyship.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easyship.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Admin findByEmailAndPassword(String email, String password);

}