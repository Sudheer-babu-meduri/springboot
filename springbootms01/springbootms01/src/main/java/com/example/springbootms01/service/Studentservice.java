package com.example.springbootms01.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.springbootms01.model.Student;
import com.example.springbootms01.repo.StudentRepo;
import com.example.springbootms01.response.Address;
import com.example.springbootms01.response.StudentResponse;

//service layer is to maintain business logic
@Service
public class Studentservice {
	
	@Autowired
	StudentRepo studentrepo;
	
	@Autowired
	ModelMapper modelmapper;;
	
	@Autowired
	RestTemplate restTemplate;

	//get all students
	public List<Student> getAllStudents(){
		
		return studentrepo.findAll();
	}
	
	public Student saveStudent(Student student) {
    return studentrepo.save(student);
}
	
	//get Student
	public StudentResponse getStudent(int id) {

    Student student = studentrepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Student not found with id : " + id));

    StudentResponse studentResponse = modelmapper.map(student, StudentResponse.class);

    Address[] addresses = restTemplate.getForObject(
            "http://localhost:8181/api/v1/getAdd/{id}",
            Address[].class,
            id
    );
    studentResponse.setAddresses(Arrays.asList(addresses));

    return studentResponse;
   }
}



