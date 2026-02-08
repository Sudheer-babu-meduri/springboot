package com.example.springbootms02.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class StudentConfig {

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper(); 
	}
	 @Bean
	    public WebClient getWebClient() {
	        return WebClient.builder().build();
	    }
}
