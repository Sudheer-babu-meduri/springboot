package com.example.jwtapp02.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jwtapp02.model.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findByUsername(String username);
}