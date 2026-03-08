package com.example.springbootms01.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Table(name = "student1")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sid;

    @NotBlank(message = "First name cannot be empty")
    @Size(min = 2, max = 30, message = "First name must be between 2 and 30 characters")
    private String fname;

    @NotBlank(message = "Last name cannot be empty")
    private String lname;

    @Min(value = 1, message = "Age must be greater than 0")
    @Max(value = 120, message = "Age must be less than 120")
    private int age;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email cannot be empty")
    private String email;
}
