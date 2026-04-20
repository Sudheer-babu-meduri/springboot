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
      
	@PostMapping("/order") 
	public Order addOrder(@RequestBody Order order) {
		return orderRepo.save(order);
	}
	
	@GetMapping
	public List<Restaurant> getAllRes(){
		return restaurantClient.getAllRestaurants();
	}
      
	@GetMapping("/{id}")  
	public ResponseEntity<OrderResponse> getOrderDetails(@PathVariable("id") int id){
		
		Order order = orderRepo.findById(id).orElseThrow();
		Restaurant restaurant = restaurantClient.getRestaurantById(order.getRestaurant_Id1());
		
		List<FoodItems> foodItems = restaurantClient.getFoodItemsByRestaurant(order.getRestaurant_Id1());

		FoodItems selected = foodItems
				             .stream()
				             .filter(f -> f.getId().equals(order.getFood_Item_Id1()))
				             .findFirst()
				             .orElse(null);
                   
		return ResponseEntity.ok(new OrderResponse(order.getCustomerName() , restaurant , selected));
	}
}