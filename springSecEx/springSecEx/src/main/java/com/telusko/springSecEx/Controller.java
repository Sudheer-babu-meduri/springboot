package com.telusko.springSecEx;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("/")
	public String get() {
		return "WELCOME SUDHEER TO DELOITTE";
	}
	
}
