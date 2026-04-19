package com.example.jwtapp02.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwtapp02.utility.JwtUtil;
import com.example.jwtapp02.model.AppUser;
import com.example.jwtapp02.model.LoginRequest;
import com.example.jwtapp02.repo.UserRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    // ✅ WRITE IT HERE
    @Autowired
    private org.springframework.security.crypto.password.PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest logReq) {

        Optional<AppUser> userOpt = userRepository.findByUsername(logReq.getUsername());

        if (userOpt.isPresent()) {

            AppUser user = userOpt.get();

            // 🔐 Compare password
            if (passwordEncoder.matches(logReq.getPassword(), user.getPassword())) {

                String token = JwtUtil.generateToken(user.getUsername());

                return "JWT Token: " + token;
            }
        }

        return "Invalid User Credentials";
    }
    
    
    @PostMapping("/register")
    public String register(@RequestBody AppUser user) {

        // encode password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);

        return "User Registered Successfully!";
    }
    
    
}