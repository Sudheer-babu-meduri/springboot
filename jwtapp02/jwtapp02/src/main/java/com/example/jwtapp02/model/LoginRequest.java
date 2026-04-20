package com.example.jwtapp02.model;

import lombok.Data;

@Data
public class LoginRequest {

    private String username;
    private String password;

    // getters & setters
}
