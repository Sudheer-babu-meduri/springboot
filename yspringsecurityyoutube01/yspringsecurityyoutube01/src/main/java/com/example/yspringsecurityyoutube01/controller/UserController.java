package com.example.yspringsecurityyoutube01.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.yspringsecurityyoutube01.model.UserEntity;
import com.example.yspringsecurityyoutube01.repo.UserRepository;
import com.example.yspringsecurityyoutube01.service.UserService;

@RestController
@RequestMapping("api/v2")
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    // ===================== USER Endpoint =====================
    @GetMapping("/me")
    public ResponseEntity<UserEntity> getCurrentUser(Authentication authentication) {
        String username = authentication.getName();
        Optional<UserEntity> userOpt = userRepository.findByUsername(username);
        return userOpt.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // ===================== ADMIN Endpoints =====================
    @GetMapping("/users")
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable Long id,
                                                 @RequestBody UserEntity updatedUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(updatedUser.getUsername());
                    user.setEmail(updatedUser.getEmail());
                    if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty()) {
                        user.setPassword(userService.encodePassword(updatedUser.getPassword()));
                    }
                    if (updatedUser.getRole() != null) {
                        user.setRole(updatedUser.getRole());
                    }
                    userRepository.save(user);
                    return ResponseEntity.ok(user);
                }).orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/users/{id}")
    public ResponseEntity<UserEntity> patchUser(@PathVariable Long id,
                                                @RequestBody UserEntity updates) {
        return userRepository.findById(id)
                .map(user -> {
                    if (updates.getUsername() != null) user.setUsername(updates.getUsername());
                    if (updates.getEmail() != null) user.setEmail(updates.getEmail());
                    if (updates.getPassword() != null && !updates.getPassword().isEmpty())
                        user.setPassword(userService.encodePassword(updates.getPassword()));
                    if (updates.getRole() != null) user.setRole(updates.getRole());
                    userRepository.save(user);
                    return ResponseEntity.ok(user);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return ResponseEntity.ok("User deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}