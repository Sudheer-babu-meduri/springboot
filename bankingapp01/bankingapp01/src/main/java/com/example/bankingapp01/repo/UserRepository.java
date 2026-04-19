package com.example.bankingapp01.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bankingapp01.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
        Optional<User> findByEmail(String email);
}