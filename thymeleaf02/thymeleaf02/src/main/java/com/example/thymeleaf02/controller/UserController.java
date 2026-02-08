package com.example.thymeleaf02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.thymeleaf02.model.User;
import com.example.thymeleaf02.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userservice;
	
	@GetMapping("/")
	String home() {
		return "login";
	}
	
	@GetMapping("/add")
	public String addUser(Model model) {
		//Model is a container to send data from backend (Java) to frontend (Thymeleaf HTML).
		model.addAttribute("user", new User());
		return "add-user";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password , Model model) {
		User user = userservice.getUserByUsernameAndPassword(username, password);
		//@RequestParam :Used to read single request parameters
		if(user!=null) {
			return "redirect:/users";
		}
		model.addAttribute("error", "Invalid User Credentials");
		return "login";
	}

	@PostMapping("/save")
	public String saveUser(@ModelAttribute User user) {
		//Used to bind multiple request parameters to a Java object (DTO / Model class).
		userservice.insertUser(user);
		return "redirect:/users";
	}
	
	@GetMapping("/users")
	String getallUsers(Model model) {
		model.addAttribute("users", userservice.getAllUsers());
		return "users";
	}
//	@RequestParam is for individual request values,
//	whereas @ModelAttribute is for binding entire form data into an object.
	
}
