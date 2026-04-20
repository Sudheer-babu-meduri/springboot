package com.example.uservalidation.service;

 import com.example.uservalidation.dto.UserRequest;
import com.example.uservalidation.entity.User;

public interface UserService {
    User registerUser(UserRequest request);
}

