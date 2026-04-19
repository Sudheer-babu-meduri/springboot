package com.example.bankingapp01.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="account")
@Data
public class Account {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String accountNumber;
	    private double balance;

	    @OneToOne
	    @JoinColumn(name = "user_id")
	    @JsonBackReference
	    private User user;
    // getters and setters
}