package com.example.restaurantservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restaurantservice.model.FoodItems;

@Repository
public interface FoodItemsRepo extends JpaRepository<FoodItems, Integer>{

List<FoodItems> findByRestaurantId(long id);//returns List of Food Items regarding the restaurant id

}
