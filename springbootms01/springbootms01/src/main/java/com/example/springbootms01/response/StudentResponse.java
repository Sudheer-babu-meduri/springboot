package com.example.springbootms01.response;

import lombok.Data;

@Data
public class StudentResponse {

		Integer sid;
		String fname;
		String lname;
		int age;
		String email;
		
		Address address;
		
	}


