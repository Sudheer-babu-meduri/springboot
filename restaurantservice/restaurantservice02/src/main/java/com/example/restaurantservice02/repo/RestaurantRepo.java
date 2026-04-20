package com.example.restaurantservice02.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restaurantservice02.model.Restaurant;


@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant, Integer>{

}
