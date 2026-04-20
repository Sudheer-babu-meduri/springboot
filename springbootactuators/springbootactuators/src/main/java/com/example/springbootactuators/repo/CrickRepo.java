package com.example.springbootactuators.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootactuators.model.Cricketer;

@Repository
public interface CrickRepo extends JpaRepository<Cricketer, Integer>{

}
