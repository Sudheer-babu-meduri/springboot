package com.example.restaurantservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restaurantservice.model.Restaurant;
import com.example.restaurantservice.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
  
	 private final RestaurantService restaurantService;

	    public RestaurantController(RestaurantService restaurantService) {
	        this.restaurantService = restaurantService;
	    }

	    // Add a new restaurant
	    @PostMapping("/addRes")
	    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
	        return restaurantService.addRestaurant(restaurant);
	    }

	    // Get all restaurants
	    @GetMapping("/getAllRes")
	    public List<Restaurant> getAllRestaurants() {
	        return restaurantService.getAllRestaurants();
	    }

	    // Get restaurant by ID
	    @GetMapping("/getByID/{id}")
	    public Restaurant getRestaurantById(@PathVariable int id) {
	        return restaurantService.getRestaurantById(id);
	    }

	    // Delete a restaurant
	    @DeleteMapping("/deleteByID/{id}")
	    public String deleteRestaurant(@PathVariable int id) {
	        restaurantService.deleteRestaurant(id);
	        return "Restaurant with ID " + id + " deleted successfully!";
	    }
}
