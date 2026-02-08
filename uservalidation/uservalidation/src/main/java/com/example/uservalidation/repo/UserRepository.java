package com.example.uservalidation.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.uservalidation.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(String phoneNumber);
    boolean existsByUserName(String userName);
}
