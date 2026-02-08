package com.example.thymeleaf03.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.thymeleaf03.model.User;
import com.example.thymeleaf03.service.UserService;

@Controller	
public class UserController {

    @Autowired
    private UserService userService;

    // Landing page
    @GetMapping("/")
    public String landingPage() {
        return "index";
    }

    // Sign up page
    @GetMapping("/add")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "add-user";
    }

    // Login page
    @GetMapping("/loginPage")
    public String loginPage() {
        return "login";
    }

    // Handle login
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userService.getUserByUsernameAndPassword(username, password);
        if (user != null) {
            return "redirect:/users"; // show all users after login
        }
        model.addAttribute("error", "Invalid User Credentials");
        return "login";
    }

    // Handle signup
    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user, Model model) {
        if (userService.getUserByUsername(user.getUsername()) != null) {
            model.addAttribute("error", "Username already exists!");
            return "add-user";
        }
        userService.insertUser(user);
        model.addAttribute("message", "Sign up successful! Please log in.");
        return "login";
    }

    // Show all users
    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    // Edit user page
    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "edit-user";
    }

    // Handle update
    @PostMapping("/update")
    public String updateUser(@ModelAttribute User user, Model model) {
        // Check duplicate username
        User existingUser = userService.getUserByUsername(user.getUsername());
        if (existingUser != null && existingUser.getUid() != user.getUid()) {
            model.addAttribute("error", "Username already exists!");
            return "edit-user";
        }
        userService.updateUser(user);
        return "redirect:/users";
    }
}
