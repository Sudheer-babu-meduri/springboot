package com.example.springsecurityapp01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class SecurityController {

	@GetMapping("/public")
	public String getPublic() {
		
		return "Hello Public";
	}
	
	@GetMapping("/user")
	public String getUser() {
		
		return "Hello User";
	}
	
	@GetMapping("/admin")
	public String getAdmin() {
		
		return "Hello Admin";
	}
	
}
