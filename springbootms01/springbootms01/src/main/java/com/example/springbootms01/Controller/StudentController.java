package com.example.springbootms01.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootms01.model.Student;
import com.example.springbootms01.response.StudentResponse;
import com.example.springbootms01.service.Studentservice;


//Controller layer is to maintain Request mapping
@RestController
@RequestMapping("api/v1") 
public class StudentController {

	@Autowired
	Studentservice studentservice;

	@PostMapping("/addStudent")
  public Student addStudent(@Valid @RequestBody Student student) {
    return studentservice.saveStudent(student);
}
	
	//get student inf0
	@GetMapping("/getAllStudents")
	List<Student> getAllStudents(){
		
		return studentservice.getAllStudents();
	}
	//get Student
	@GetMapping("/getStudent/{id}")
	StudentResponse getStudent(@PathVariable int id) {
		return studentservice.getStudent(id);
	}
}
