package com.example.springbootms01.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootms01.response.StudentResponse;
import com.example.springbootms01.service.Studentservice;


//Controller layer is to maintain Request mapping
@RestController
@RequestMapping("api/v1") 
public class StudentController {

	@Autowired
	Studentservice studentservice;
	
	//get student info
	
	//get Student
	@GetMapping("/getStudent/{id}")
	StudentResponse getStudent(@PathVariable int id) {
		return studentservice.getStudent(id);
	}
	
	@GetMapping("/getAllStudents")
	public List<StudentResponse> getAllStudents() {
	    return studentservice.getAllStudentsWithAddresses();
	}
}
