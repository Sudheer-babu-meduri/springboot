package com.example.thymeleaf02.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.thymeleaf02.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

	User findUSerByUsernameAndPassword(String username,String password);
}
