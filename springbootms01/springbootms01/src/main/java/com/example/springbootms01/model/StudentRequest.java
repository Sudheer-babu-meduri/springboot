package com.example.springbootms01.model;

import java.util.List;

import com.example.springbootms01.response.Address;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class StudentRequest {

    @NotBlank(message = "First name cannot be empty")
    private String fname;

    @NotBlank(message = "Last name cannot be empty")
    private String lname;

    @Min(value = 1, message = "Age must be greater than 0")
    @Max(value = 120, message = "Age must be less than 120")
    private int age;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email cannot be empty")
    private String email;

    private List<Address> addresses;
}