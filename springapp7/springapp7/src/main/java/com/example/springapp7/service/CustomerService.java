package com.example.springapp7.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp7.model.Customer;
import com.example.springapp7.repo.CustomerRepo;

@Service
public class CustomerService {

	@Autowired
	CustomerRepo customerrepo;
	
	//insert customers
	public Customer insertCustomer(Customer customer) {
		return customerrepo.save(customer);
	}
	
	//get All Customers
	public List<Customer> getAllCustomer(){
		return customerrepo.findAll();
	}
	
	//getCustomer By Id
	public Customer getCustomerById(int id){
		return customerrepo.findById(id).orElseThrow(() -> new RuntimeException("ID not found"));
	}
	
	//getCustomer By name
	public List<Customer> getCustomerByCname(String name){
		return customerrepo.findByCname(name);
	}
	
	//get all by priority
	 public List<Customer> getAllCustomersByPrio() {
	        return customerrepo.findAllByOrderByPrioDesc();
	    } 
	
	//update customer
	
	public Customer updateCustomer(Customer customer) {
		return customerrepo.save(customer);
	}
	
	//delete Customer
	public String deleteById(int id) {
		customerrepo.deleteById(id);
		return "Id "+id+" Has been deleted Successfully";
	}
	
}
