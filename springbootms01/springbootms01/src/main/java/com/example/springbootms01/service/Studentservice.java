package com.example.springbootms01.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.springbootms01.model.Student;
import com.example.springbootms01.repo.StudentRepo;
import com.example.springbootms01.response.Address;
import com.example.springbootms01.response.StudentResponse;

@Service
public class Studentservice {

    @Autowired
    private StudentRepo studentrepo;

    @Autowired
    private ModelMapper modelmapper;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * Get single student by ID with addresses
     */
    public StudentResponse getStudent(int id) {

        // 1️⃣ Fetch student from DB
        Student student = studentrepo.findById(id)
                .orElseThrow();

        // 2️⃣ Map entity to response DTO
        StudentResponse studentResponse = modelmapper.map(student, StudentResponse.class);

        // 3️⃣ Fetch addresses from Address microservice
        Address[] addresses = restTemplate.getForObject(
                "http://localhost:8181/api/v1/getAdd/{id}",  // Address service URL
                Address[].class,
                id
        );

        // 4️⃣ Set addresses safely
        if (addresses != null) {
            studentResponse.setAddresses(Arrays.asList(addresses));
        }

        return studentResponse;
    }

    /**
     * Get all students with their addresses
     */
    public List<StudentResponse> getAllStudentsWithAddresses() {

        List<Student> students = studentrepo.findAll();
        List<StudentResponse> responses = new ArrayList<>();

        for (Student student : students) {

            // Map student entity to response DTO
            StudentResponse studentResponse = modelmapper.map(student, StudentResponse.class);

            // Fetch addresses from Address microservice
            ResponseEntity<List<Address>> addressResponse = restTemplate.exchange(
                    "http://localhost:8181/api/v1/getAllAdd/{id}",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Address>>() {},
                    student.getSid()
            );

            List<Address> addresses = addressResponse.getBody();

            // Set addresses safely
            studentResponse.setAddresses(addresses);

            responses.add(studentResponse);
        }

        return responses;
    }
}