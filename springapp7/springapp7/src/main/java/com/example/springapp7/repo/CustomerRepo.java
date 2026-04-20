package com.example.springapp7.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springapp7.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

	  List<Customer> findByCname(String cname);
	  List<Customer> findAllByOrderByPrioDesc();
 
  }