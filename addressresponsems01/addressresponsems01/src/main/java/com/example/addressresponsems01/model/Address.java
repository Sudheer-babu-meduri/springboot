package com.example.addressresponsems01.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Table(name = "address1")
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
    private Integer id;

    @NotNull(message = "Flat number cannot be null")
    private Integer fno;

    @NotBlank(message = "Street cannot be empty")
    @Size(min = 3, max = 50, message = "Street must be between 3 and 50 characters")
    private String street;

    @NotBlank(message = "City cannot be empty")
    private String city;

    @NotBlank(message = "State cannot be empty")
    private String state;

    @NotNull(message = "Pincode is required")
    @Digits(integer = 6, fraction = 0, message = "Pincode must be 6 digits")
    private Long pincode;

    @NotNull(message = "Student Id cannot be null")
    @Column(name = "student_id")
    private Integer studentId;
}
