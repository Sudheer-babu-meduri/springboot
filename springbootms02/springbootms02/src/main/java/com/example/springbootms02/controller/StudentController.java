package com.example.springbootms02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootms02.response.StudentResponse;
import com.example.springbootms02.service.StudentService;

@RestController
@RequestMapping("api/v1")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@GetMapping("/getStudent/{id}")
	StudentResponse getstudent(@PathVariable int id) {
		return studentService.getStudent(id);
	}
}
