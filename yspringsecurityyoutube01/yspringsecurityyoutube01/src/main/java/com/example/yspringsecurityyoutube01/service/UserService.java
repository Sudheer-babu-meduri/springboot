package com.example.yspringsecurityyoutube01.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.yspringsecurityyoutube01.model.UserEntity;
import com.example.yspringsecurityyoutube01.repo.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Signup new user
    public UserEntity registerUser(String username, String email, String rawPassword) {
        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(rawPassword));
        user.setRole("USER");  // Always USER
        return userRepository.save(user);
    }

    // Encode password helper (for admin updates)
    public String encodePassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }
}