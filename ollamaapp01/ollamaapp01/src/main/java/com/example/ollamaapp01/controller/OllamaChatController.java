package com.example.ollamaapp01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ollamaapp01.service.OllamaChatService;

@RestController
@RequestMapping("api/v1/chat")
public class OllamaChatController {

	@Autowired
	OllamaChatService ollamaResponse;
	
	@GetMapping
	public String chat(@RequestParam String message) {
		
		return ollamaResponse.chat(message);
	}
	
}
