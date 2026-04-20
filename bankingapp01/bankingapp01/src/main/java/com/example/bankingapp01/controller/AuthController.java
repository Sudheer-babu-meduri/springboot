package com.example.bankingapp01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bankingapp01.entity.Account;
import com.example.bankingapp01.entity.Role;
import com.example.bankingapp01.entity.User;
import com.example.bankingapp01.exceptions.DuplicateResourceException;
import com.example.bankingapp01.exceptions.ResourceNotFoundException;
import com.example.bankingapp01.repo.UserRepository;
import com.example.bankingapp01.utility.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
    private UserRepository userRepo;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
    	
    	 if (userRepo.findByUsername(user.getUsername()).isPresent()) {
    	        throw new DuplicateResourceException("Username already exists");
    	    }

    	    if (userRepo.findByEmail(user.getEmail()).isPresent()) {
    	        throw new DuplicateResourceException("Email already exists");
    	    }

    	user.setRole(Role.USER);

        Account acc = new Account();
        acc.setBalance(0);
        acc.setAccountNumber("ACC" + System.currentTimeMillis());

        user.setAccount(acc);
        acc.setUser(user);

        return userRepo.save(user);
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {
    	 System.out.println("LOGIN API CALLED");

        User user = userRepo.findByUsername(username)
            .orElseThrow(() -> new ResourceNotFoundException("Name Not found"));

        if (!user.getPassword().equals(password)) {
            throw new ResourceNotFoundException("Invalid Credentials");
        }

        String token = jwtUtil.generateToken(user.getUsername(), user.getRole().name());

        System.out.println("Generated Token: " + token); // DEBUG
System.out.println("%******************************************************************************************************8");
        return token;
    }
}