package com.example.springsecurityapp02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@GetMapping("/wel")
	public String welcome() {
		return "Welcome to Spring Security";
	}

	@GetMapping("/admin")
	public String admin() {
		return "Welcome Admin";
	}
	
	@GetMapping("/user")
	public String user() {
		return "Welcome USER";
	}
}
