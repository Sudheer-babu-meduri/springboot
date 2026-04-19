package com.example.uservalidation2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Table(name = "user7")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Pattern(
	    regexp = "^[A-Za-z][A-Za-z ]{2,19}$",
	    message = "Username must start with a letter and can contain letters, digits, or spaces (3-20 chars)"
    	)
    private String name;

    @Email(message = "Email should be valid")
    @Pattern(
    	    regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",
    	    message = "Email must contain valid domain (e.g. example@gmail.com)"
    	)
    @Column(unique = true)
    private String email;

    // Constructors
    public User() {}

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

}
