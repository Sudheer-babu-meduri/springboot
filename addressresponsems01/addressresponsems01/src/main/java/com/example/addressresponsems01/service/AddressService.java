 package com.example.addressresponsems01.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.addressresponsems01.model.Address;
import com.example.addressresponsems01.repo.AddressRepo;

@Service
public class AddressService {

	@Autowired
	AddressRepo addressRepo;
	
	
//	get address info by Id
	public List<Address> getAddressById(int id) {
	    return addressRepo.findAddressByStudentId(id);
	}
	
	public List<Address> getAddressesByStudentId(int student_id) {
        return addressRepo.findByStudentId(student_id);
    }
}
