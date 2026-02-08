package com.example.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderservice.client.RestaurantClient;
import com.example.orderservice.model.Order;
import com.example.orderservice.repo.OrderRepo;
import com.example.orderservice.response.FoodItems;
import com.example.orderservice.response.OrderResponse;
import com.example.orderservice.response.Restaurant;

@RestController
public class OrderController {

	@Autowired
	OrderRepo orderRepo;
	
	@Autowired
	RestaurantClient restaurantClient;
	
	@PostMapping("addOrder")
	public Order addOrder(@RequestBody Order order) {
		return orderRepo.save(order);
	}
	
	@GetMapping("getOrder/{id}")
	public ResponseEntity<OrderResponse> getOrder(@PathVariable int id){
		Order order = orderRepo.findById(id).orElseThrow();
		
		Restaurant restaurant = restaurantClient.getRestaurant(order.getRestaurantId());
		List<FoodItems> foodItems = restaurantClient.getFoodItems(order.getFoodItemId());
		 
		FoodItems selected = foodItems.stream()
				              .filter(f ->f.getId().equals(order.getFoodItemId()))
				              .findFirst()
				              .orElse(null);
		
		return ResponseEntity.ok(new OrderResponse(order.getCustomerName(),restaurant,selected));
		
		
		
	}
}
