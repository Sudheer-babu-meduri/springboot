package com.example.restaurantservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restaurantservice.model.FoodItems;
import com.example.restaurantservice.model.Restaurant;
import com.example.restaurantservice.service.FoodItemsService;
import com.example.restaurantservice.service.RestaurantService;

@RestController
@RequestMapping("api/v1")
public class RestaurantController {
  
	@Autowired
	RestaurantService restaurantService;
	
	@Autowired
	FoodItemsService foodItemsService;
	
	@PostMapping("addRes")
	public  Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
		return restaurantService.createrestaurant(restaurant);
	}
	@GetMapping("getRes/{id}")
	public  Restaurant getRestaurant(@PathVariable int id) {
		return restaurantService.getrestaurantById(id);
	}
	
	@PostMapping("addItems")
	public FoodItems createFoodItems(@RequestBody FoodItems foodItems) {
        return foodItemsService.createfoodItems(foodItems);
      }
	
	@GetMapping("getItems/{id}")
	public List<FoodItems> getFoodItems(@PathVariable int id){
		return foodItemsService.findByRestaurantId(id);
	}
	
	
}
