package com.example.addressresponsems01.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "address1")
@Data 
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	Integer id;
	Integer fno;
	String street;
	String city;
	String state;
	long pincode;
	
	Integer student_id;
}
