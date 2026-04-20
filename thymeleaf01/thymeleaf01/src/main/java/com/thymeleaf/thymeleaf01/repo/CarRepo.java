package com.thymeleaf.thymeleaf01.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thymeleaf.thymeleaf01.model.Car;

public interface CarRepo extends JpaRepository<Car, Long> {

}
