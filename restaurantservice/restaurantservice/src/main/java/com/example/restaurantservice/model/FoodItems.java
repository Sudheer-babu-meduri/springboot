package com.example.restaurantservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "fooditems61")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodItems {

	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String name;
	Double price;
	
	@ManyToOne
	@JoinColumn(name = "restaurant_id" ,referencedColumnName = "id" )
	@JsonBackReference
	Restaurant restaurant;
	
}