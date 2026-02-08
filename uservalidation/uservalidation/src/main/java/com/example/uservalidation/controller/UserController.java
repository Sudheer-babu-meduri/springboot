package com.example.uservalidation.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.uservalidation.dto.UserRequest;
import com.example.uservalidation.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/insertUser")
    public ResponseEntity<String> createUser(@Valid @RequestBody UserRequest request) {
        userService.registerUser(request);
        return ResponseEntity.ok("User registered successfully");
    }
}
//@PostMapping("/insertUser")
//public ResponseEntity<String> createUser(@Valid @RequestBody UserRequest request) {
//    userService.registerUser(request);
//    return ResponseEntity.ok("User registered successfully");
//}
//1️⃣ Client Sends HTTP Request
//Example JSON POST request:
//
//json
//Copy code
//{
//  "userName": "sudheer",
//  "email": "sudheer@gmail.com",
//  "phoneNumber": "9876543210"
//}
//Client could be Postman, Swagger, Angular/React frontend, etc.
//
//HTTP request goes to Spring Boot app at endpoint /insertUser.
//
//2️⃣ Spring MVC Reads Request Body
//@RequestBody tells Spring:
//
//“Take the raw JSON from the HTTP request body and convert it into a Java object.”
//
//Spring uses a library called Jackson (built-in in Spring Boot) to do this conversion.
//
//3️⃣ JSON → UserRequest Object (Deserialization)
//Jackson maps JSON fields to your Java class:
//
//JSON key	Java field
//"userName"	private String userName
//"email"	private String email
//"phoneNumber"	private String phoneNumber
//
//Behind the scenes, Jackson does something like:
//
//java
//Copy code
//UserRequest request = new UserRequest();
//request.setUserName("sudheer");
//request.setEmail("sudheer@gmail.com");
//request.setPhoneNumber("9876543210");
//4️⃣ Validation Happens (@Valid)
//Because you wrote @Valid @RequestBody UserRequest request, Spring automatically checks the validation annotations:
//
//java
//Copy code
//@NotBlank(message = "Username is required")
//@Email(message = "Invalid email format")
//@Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid phone number")
//If the JSON fails any of these rules, Spring will stop here and return 400 Bad Request with error messages.
//
//If it passes, Spring proceeds to the next step.
//
//5️⃣ UserRequest is Passed to Service
//java
//Copy code
//userService.registerUser(request);
//Now you have a fully populated UserRequest object in Java.
//
//You can read request.getUserName(), request.getEmail(), etc.
//
//Service layer uses this object to perform duplicate checks and save to DB.
//
//✅ TL;DR in Super Simple Words
//Client sends JSON.
//
//@RequestBody → Spring uses Jackson → turns JSON into UserRequest object.
//
//@Valid → Spring checks annotations (@Email, @NotBlank, etc).
//
//Controller method receives a ready-to-use Java object.
//
//You call service with this object → DB → Response.
//
//💡 Analogy:
//
//Think of JSON as a letter in English.
//
//UserRequest is the internal form you fill from the letter.
//
//@RequestBody = translator.
//
//@Valid = proofreader.
//
//Service + Repository = filing cabinet where the info is stored.