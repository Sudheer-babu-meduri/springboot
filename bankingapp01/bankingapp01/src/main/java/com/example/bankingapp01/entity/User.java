package com.example.bankingapp01.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="user")
@Data
public class User {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String username;
	    private String email;
	    private String password;
	    private String phone;

	    @Enumerated(EnumType.STRING)
	    private Role role;

	    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	    @JsonManagedReference
	    private Account account;
	     
    // getters & setters omitted for brevity
}