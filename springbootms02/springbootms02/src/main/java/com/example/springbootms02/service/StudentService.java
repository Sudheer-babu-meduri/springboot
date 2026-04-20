package com.example.springbootms02.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.springbootms02.model.Student;
import com.example.springbootms02.repo.StudentRepo;
import com.example.springbootms02.response.Address;
import com.example.springbootms02.response.StudentResponse;

@Service
public class StudentService {

	@Autowired
	StudentRepo studentRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	WebClient webClient;
	
	
	public StudentResponse getStudent(int id) {
		 
		Student student = studentRepo.findById(id).orElseThrow();
		
		StudentResponse studentResponse = modelMapper.map(student, StudentResponse.class);
		
		Address address = webClient.get()
				.uri("http://localhost:6161/api/v1/getAdd/{id}", id)
				.retrieve().bodyToMono(Address.class).block();   
		
		studentResponse.setAddress(address);
		return studentResponse;
		
	}
}
