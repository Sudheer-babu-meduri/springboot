package com.example.jwtapp01.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwtapp01.model.LoginRequest;
import com.example.jwtapp01.utility.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {
	

	@PostMapping("/login")
	public String login(@RequestBody LoginRequest logReq) {
		    
		if(logReq.getUsername().equals("sudheer") && logReq.getPassword().equals("6666")) {
			
			String token = JwtUtil.generateToken(logReq.getUsername());
			
			return "JWT Token: "+token;
			
		}
		return "Invalid User Credentials";
	}
	
}
