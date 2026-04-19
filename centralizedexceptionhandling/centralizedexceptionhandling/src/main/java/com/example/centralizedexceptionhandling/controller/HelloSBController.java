package com.example.centralizedexceptionhandling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.centralizedexceptionhandling.Student;
import com.example.centralizedexceptionhandling.exception.ResourceNotFoundException;
import com.example.centralizedexceptionhandling.repo.StudentRepo;

@RestController
@RequestMapping("api/v1")
public class HelloSBController {

	@Autowired
	StudentRepo studentrepo;
	
	@GetMapping("student/{id}")
    public Student getStudent(@PathVariable int id) {
		
		return studentrepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student Not Found with ID:"+id));
	}
	
	@GetMapping("getall")
	public List<Student> allStudents(){
		
		return studentrepo.findAll();
	}
	
}
