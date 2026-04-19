package com.example.restaurantservice.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

 
@Entity
@Table(name = "restaurant61")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
            
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String name;
	
	@OneToMany(mappedBy = "restaurant")
	@JsonManagedReference
    List<FoodItems> foodItems;
}
