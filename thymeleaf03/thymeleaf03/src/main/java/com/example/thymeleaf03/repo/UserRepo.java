package com.example.thymeleaf03.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.thymeleaf03.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    User findUserByUsernameAndPassword(String username, String password);
    User findUserByUsername(String username);
}
