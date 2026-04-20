package com.example.orderservice.response;

import lombok.Data;

@Data
public class FoodItems {

	
	Integer id;
	String name;
	double price;
	Restaurant restaurant;
	
}
