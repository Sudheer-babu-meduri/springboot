package com.example.thymeleaf03.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.thymeleaf03.model.User;
import com.example.thymeleaf03.repo.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public void insertUser(User user) {
        userRepo.save(user);
    }

    public void updateUser(User user) {
        userRepo.save(user);
    }

    public User getUserById(int id) {
        return userRepo.findById(id).orElse(null);
    }

    public User getUserByUsername(String username) {
        return userRepo.findUserByUsername(username);
    }

    public User getUserByUsernameAndPassword(String username, String password) {
        return userRepo.findUserByUsernameAndPassword(username, password);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
