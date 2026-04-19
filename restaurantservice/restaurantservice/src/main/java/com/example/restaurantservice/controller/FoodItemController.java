package com.example.restaurantservice.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.restaurantservice.model.FoodItems;
import com.example.restaurantservice.service.FoodItemsService;

@RestController
@RequestMapping("foodItem")
public class FoodItemController {

	private final FoodItemsService foodItemsService;

    public FoodItemController(FoodItemsService foodItemsService) {
        this.foodItemsService = foodItemsService;
    }

    // Add food item to a restaurant
    @PostMapping("/restaurant/{restaurantId}")
    public FoodItems addFoodItemToRestaurant(@PathVariable int restaurantId,
                                             @RequestBody FoodItems foodItem) {
        return foodItemsService.addFoodItemToRestaurant(restaurantId, foodItem);
    }

    // Get all food items for a restaurant
    @GetMapping("/restaurant/{restaurantId}")
    public List<FoodItems> getFoodItemsByRestaurant(@PathVariable int restaurantId) {
        return foodItemsService.findByRestaurantId(restaurantId);
    }

    // Delete a food item
    @DeleteMapping("/{foodItemId}")
    public String deleteFoodItem(@PathVariable int foodItemId) {
        foodItemsService.deleteFoodItem(foodItemId);
        return "Food item with ID " + foodItemId + " deleted successfully!";
    }
	
}
