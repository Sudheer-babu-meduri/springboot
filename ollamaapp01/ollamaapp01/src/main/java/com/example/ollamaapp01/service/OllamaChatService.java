package com.example.ollamaapp01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.ollamaapp01.model.OllamaRequest;
import com.example.ollamaapp01.model.OllamaResponse;

@Service
public class OllamaChatService {

	
	@Autowired
	RestTemplate restTemplate;
	
	private final String OLLAMA_URL = "http://localhost:11434/api/generate";

	public String chat(String message) {
		
		OllamaRequest request = new OllamaRequest("llama3.2:3b",message,false);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<OllamaRequest> entity = new HttpEntity<>(request,headers);
		
		ResponseEntity<OllamaResponse> response = restTemplate.postForEntity(OLLAMA_URL, entity, OllamaResponse.class);
		
		return response.getBody().getResponse();
	}
}
