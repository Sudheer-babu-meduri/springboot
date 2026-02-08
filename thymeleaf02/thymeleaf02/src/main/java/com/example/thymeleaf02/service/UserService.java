package com.example.thymeleaf02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.thymeleaf02.model.User;
import com.example.thymeleaf02.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userrepo;
	public User getUserByUsernameAndPassword(String username,String password) {
		return userrepo.findUSerByUsernameAndPassword(username, password);
	}
	//*************************************************8
	public List<User> getAllUsers(){
		return userrepo.findAll();
	}
	//*************************************************8
	public User getUserById(int uid) {
		return userrepo.findById(uid).orElse(null);
	}
	//*************************************************8
    public User insertUser(User user) {
    	return userrepo.save(user);
    }
	//*************************************************8
   public void deletUserById(int uid) {
	   userrepo.deleteById(uid);
   }
    
}
