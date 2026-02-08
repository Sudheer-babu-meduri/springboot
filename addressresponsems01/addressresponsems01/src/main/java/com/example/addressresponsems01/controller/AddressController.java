package com.example.addressresponsems01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.addressresponsems01.model.Address;
import com.example.addressresponsems01.service.AddressService;

@RestController
@RequestMapping("api/v1")
public class AddressController {

	@Autowired
	AddressService addressService;
	
	@GetMapping("getAdd/{id}")
	public Address getAddressById(@PathVariable int id) {
		return addressService.getAddressById(id);
	}
}
