package com.example.springapp7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp7.model.Customer;
import com.example.springapp7.service.CustomerService;


@RestController
@RequestMapping("api/v7")
public class CustomerController {

	@Autowired
	CustomerService customerservice;
	
	//update customer 
	@PatchMapping("updateCustomer/{cid}")
	Customer updateCustomer(@RequestBody Customer customer , @PathVariable("cid") int cid) {
		
		Customer existcustomer = customerservice.getCustomerById(cid);
		existcustomer.setCname(customer.getCname());
		existcustomer.setItems(customer.getItems());
		existcustomer.setBill(customer.getBill());
		return customerservice.updateCustomer(existcustomer);
	}
	
	//insert customer
	@PostMapping("insertCustomer")
	Customer insertCustomer(@RequestBody Customer customer) {
		return customerservice.insertCustomer(customer);
	}
	
	//get All customers
	@GetMapping("getAllCustomers")
	List<Customer> getAllCustomers(){
		return customerservice.getAllCustomer();
	}
	
	//get all customers by sorting prio
	 @GetMapping("/getAllCustomersByPrio")
	    public List<Customer> getCustomers() {
	        // Returns all customers sorted by prio ascending
	        return customerservice.getAllCustomersByPrio();
	    }
	
	//get Customer By Id
	@GetMapping("getCustomerById/{cid}")
	Customer getCustomerById(@PathVariable("cid") int cid) {
		return customerservice.getCustomerById(cid);
	}
	//get Customer By name
	@GetMapping("getCustomerByName/{cname}")
	List<Customer> getCustomerByname(@PathVariable("cname") String cname){
		return customerservice.getCustomerByCname(cname);
	}
	//delete customer
	@DeleteMapping("deleteCustomer/{cid}")
	String deleteCustomer(@PathVariable("cid") int cid) {
		return customerservice.deleteById(cid);
	}
}