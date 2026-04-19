package com.example.orderservice.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderResponse { 

	String customerName;
	Restaurant restaurant;
	FoodItems foodItems;
	 
}
