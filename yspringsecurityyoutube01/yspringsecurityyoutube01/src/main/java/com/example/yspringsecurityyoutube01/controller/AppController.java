package com.example.yspringsecurityyoutube01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.yspringsecurityyoutube01.model.UserEntity;
import com.example.yspringsecurityyoutube01.service.UserService;

@RestController
@RequestMapping("api/v1")
public class AppController {

    private final UserService userService;

    public AppController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/home")
    public String home() {
        return "Welcome to Home!";
    }

    @PostMapping("/signup")
    public String signup(@RequestParam String username,
                         @RequestParam String email,
                         @RequestParam String password) {
        UserEntity user = userService.registerUser(username, email, password);
        return "User registered with ID: " + user.getId();
    }
}