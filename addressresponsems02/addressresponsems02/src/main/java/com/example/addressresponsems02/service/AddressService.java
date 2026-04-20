 package com.example.addressresponsems02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.addressresponsems02.model.Address;
import com.example.addressresponsems02.repo.AddressRepo;


@Service
public class AddressService {

	@Autowired
	AddressRepo addressRepo;
	
	
//	get address info by Id
	  public Address getAddressById(int id) {
		  return addressRepo.findAddressByStudentId(id).orElseThrow();
	    
	  }
}
