package com.example.uservalidation2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.uservalidation2.exception.DuplicateResourceException;
import com.example.uservalidation2.exception.ResourceNotFoundException;
import com.example.uservalidation2.model.User;
import com.example.uservalidation2.repo.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {

        userRepository.findByEmail(user.getEmail())
                .ifPresent(n -> {
                    throw new DuplicateResourceException("Email already exists");
                });

        return userRepository.save(user);
    }

    public User getUserById(Long id) {

        return userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with id: " + id));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}