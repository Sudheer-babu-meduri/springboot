package com.example.uservalidation2.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.uservalidation2.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    
}