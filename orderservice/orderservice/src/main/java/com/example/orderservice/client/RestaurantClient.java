package com.example.orderservice.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.orderservice.response.FoodItems;
import com.example.orderservice.response.Restaurant;

@FeignClient(name = "restaurantservice", url = "http://localhost:9999")
public interface RestaurantClient {

//	Get restaurant by ID
	 @GetMapping("/restaurant/getByID/{id}")
	    Restaurant getRestaurantById(@PathVariable int id);

	    // Get all restaurants
	    @GetMapping("/restaurant/getAllRes")
	    List<Restaurant> getAllRestaurants();

	    //Get food items by restaurant
	    @GetMapping("/foodItem/restaurant/{restaurantId}")
	    List<FoodItems> getFoodItemsByRestaurant(@PathVariable int restaurantId);
	}
