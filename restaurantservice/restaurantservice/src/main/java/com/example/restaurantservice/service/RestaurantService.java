package com.example.restaurantservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.restaurantservice.exception.RestaurantNotFoundException;
import com.example.restaurantservice.model.Restaurant;
import com.example.restaurantservice.repo.RestaurantRepo;

@Service
public class RestaurantService {

	 private final RestaurantRepo restaurantRepo;

	  public RestaurantService(RestaurantRepo restaurantRepo) {
	        this.restaurantRepo = restaurantRepo;
	    }
	
	public Restaurant createrestaurant(Restaurant restaurant) {
		
		return restaurantRepo.save(restaurant);
	}
	
	  // Add new restaurant
    public Restaurant addRestaurant(Restaurant restaurant) {
        if (restaurant.getName() == null || restaurant.getName().isEmpty()) {
            throw new IllegalArgumentException("Restaurant name cannot be empty");
        }
        return restaurantRepo.save(restaurant);
    }
	
	 // Get restaurant by ID
    public Restaurant getRestaurantById(int id) {
        return restaurantRepo.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant with ID " + id + " not found"));
    }
	// Get ALL Restaurant
	 public List<Restaurant> getAllRestaurants() {
	        List<Restaurant> restaurants = restaurantRepo.findAll();
	        if (restaurants.isEmpty()) {
	            throw new RestaurantNotFoundException("No restaurants found!");
	        }
	        return restaurants;
	    }
	 
	// Delete a restaurant
	    public void deleteRestaurant(int id) {
	        Restaurant restaurant = restaurantRepo.findById(id)
	                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant with ID " + id + " not found"));
	        restaurantRepo.delete(restaurant);
	    }
}
