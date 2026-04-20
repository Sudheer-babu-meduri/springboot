package com.example.springbootactuators.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "cricketer7")
@Data
public class Cricketer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer jersyno;
	String name;
	Integer iccrank;
	
}
