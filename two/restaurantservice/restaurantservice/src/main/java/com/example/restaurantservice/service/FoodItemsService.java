package com.example.restaurantservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restaurantservice.model.FoodItems;
import com.example.restaurantservice.repo.FoodItemsRepo;


@Service
public class FoodItemsService {

	@Autowired
	FoodItemsRepo foodItemsRepo;
	
	public FoodItems createfoodItems(FoodItems foodItems) {
		return foodItemsRepo.save(foodItems);
	}
	
	public List<FoodItems> findByRestaurantId(int id){
		return foodItemsRepo.findByRestaurantId(id);
	}
}

