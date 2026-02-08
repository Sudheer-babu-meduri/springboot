package com.example.restaurantservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restaurantservice.model.Restaurant;
import com.example.restaurantservice.repo.RestaurantRepo;

@Service
public class RestaurantService {

	@Autowired
	RestaurantRepo restaurantRepo;
	
	public Restaurant createrestaurant(Restaurant restaurant) {
		
		return restaurantRepo.save(restaurant);
	}
	
	public Restaurant getrestaurantById(int id) {
		return restaurantRepo.findById(id).orElseThrow();
	}
	
}
