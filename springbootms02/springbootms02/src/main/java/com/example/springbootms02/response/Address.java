package com.example.springbootms02.response;

import lombok.Data;

@Data
public class Address {

	Integer fno;
	String street;
	String city;
	String state;
	long pincode;
}
