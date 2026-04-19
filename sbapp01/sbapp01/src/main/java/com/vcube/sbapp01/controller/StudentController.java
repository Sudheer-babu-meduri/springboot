package com.vcube.sbapp01.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vcube.sbapp01.model.Student;
import com.vcube.sbapp01.repo.StudentRepo;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "http://localhost:3000")
 public class StudentController {

	@Autowired
	StudentRepo studentrepo;
	
	@GetMapping("/meduri")
	String getDetails() {
		return "MEDURI SUDHEER BABU";
	}
	
	// 1) for inserting into data base
	// http://localhost:9999/api/v1/insertStudent
	@PostMapping("/insertStudent")
	Student insertStudent(@RequestBody Student student) {
		return studentrepo.save(student);
	}
	//2)For getting data from data base 
	// http://localhost:9999/api/v1/getAllStudents
	@GetMapping("getAllStudents")
	List<Student> getAllStudents(){
	List<Student> student = new ArrayList<>();
	
       student = studentrepo.findAll();
       return student;
	}
	
	//3)For getting Data from DB based on ID
	// http://localhost:9999/api/v1/getStudentById/3
	@GetMapping("getStudentById/{sid}")
		 Optional<Student> getStudentById(@PathVariable("sid") int sid){
		return studentrepo.findById(sid);
	}
	//4)For getting Data from DB based on name or address or branch 
	// http://localhost:9999/api/v1/getStudentByName/sudheer
	@GetMapping("getStudentByName/{sname}")
	Optional<Student> getStudentByName(@PathVariable("sname") String sname){
		return studentrepo.findBySname(sname);
	}
	
	//5)Update all columns of Student using @PutMapping 
	// http://localhost:9999/api/v1/updateStudent/3
	
	@PutMapping("updateStudent/{sid}") 
  Student updateStudent(@RequestBody Student student ,@PathVariable ("sid") int sid){
	Student existStudent = studentrepo.findById(sid)
			  .orElseThrow(() -> new RuntimeException("Student not fount with id "+sid)); 
		existStudent.setCity(student.getCity()); 
		existStudent.setSname(student.getSname()); 
		existStudent.setMobile(student.getMobile());
		existStudent.setAge(student.getAge());
		return studentrepo.save(existStudent); 
	}
	
	//6)Update any one column of Student using @PatchMapping
	// http://localhost:9999/api/v1/patchWork/3
	@PatchMapping("patchWork/{sid}")
   Student updateStudentPatch(@RequestBody Student student , @PathVariable("sid") int sid) {
		
	Student existStudent = studentrepo.findById(sid)
			            .orElseThrow(() -> new RuntimeException("Student not found with ID :"+sid));
	
	existStudent.setCity(student.getCity());
	 
	return studentrepo.save(existStudent);

	}
	
	//7)Deleting a student based on ID
	// http://localhost:9999/api/v1/deleteStudentById/3
	@DeleteMapping("deleteStudent/{sid}")
	String deleteStudent(@PathVariable("sid") int sid) {
		
		studentrepo.deleteById(sid);
		return "Student "+sid+" has been deleted";
	}
	
 }
