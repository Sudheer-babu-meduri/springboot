package com.example.yspringsecurityyoutube01.repo;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.yspringsecurityyoutube01.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
}