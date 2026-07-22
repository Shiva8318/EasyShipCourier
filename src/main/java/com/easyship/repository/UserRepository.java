package com.easyship.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.easyship.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);
    User findByEmailAndPassword(String email, String password);

}