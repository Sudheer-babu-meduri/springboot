package com.example.restaurantservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.restaurantservice.exception.FoodItemNotFoundException;
import com.example.restaurantservice.exception.InvalidDataException;
import com.example.restaurantservice.exception.RestaurantNotFoundException;
import com.example.restaurantservice.model.FoodItems;
import com.example.restaurantservice.model.Restaurant;
import com.example.restaurantservice.repo.FoodItemsRepo;
import com.example.restaurantservice.repo.RestaurantRepo;


@Service
public class FoodItemsService {

	 private final FoodItemsRepo foodItemsRepo;
	    private final RestaurantRepo restaurantRepo;
	    
	    public FoodItemsService(FoodItemsRepo foodItemsRepo, RestaurantRepo restaurantRepo) {
	        this.foodItemsRepo = foodItemsRepo;
	        this.restaurantRepo = restaurantRepo;
	    }
	
	    public FoodItems addFoodItemToRestaurant(int restaurantId, FoodItems foodItem) {
	        Restaurant restaurant = restaurantRepo.findById(restaurantId)
	                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant with ID " + restaurantId + " not found"));

	        validateFoodItem(foodItem);

	        foodItem.setRestaurant(restaurant);
	        return foodItemsRepo.save(foodItem);
	    }
	    private void validateFoodItem(FoodItems foodItem) {
	        if (foodItem.getName() == null || foodItem.getName().isEmpty()) {
	            throw new InvalidDataException("Food item name cannot be empty");
	        }
	        if (foodItem.getPrice() == null || foodItem.getPrice() <= 0) {
	            throw new InvalidDataException("Food item price must be greater than 0");
	        }
	    }
	    public void deleteFoodItem(int foodItemId) {
	        FoodItems foodItem = foodItemsRepo.findById(foodItemId)
	                .orElseThrow(() -> new FoodItemNotFoundException("Food item with ID " + foodItemId + " not found"));
	        foodItemsRepo.delete(foodItem);
	    }
	    
	public List<FoodItems> findByRestaurantId(int id){
		return foodItemsRepo.findByRestaurant_Id(id);
	}
	
	
}
