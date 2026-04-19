package com.example.restaurantservice02.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restaurantservice02.model.FoodItems;


@Repository
public interface FoodItemsRepo extends JpaRepository<FoodItems, Integer> {
    List<FoodItems> findByRestaurant_Id(Integer id);
    
}
