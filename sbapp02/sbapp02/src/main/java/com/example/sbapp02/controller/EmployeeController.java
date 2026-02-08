package com.example.sbapp02.controller;

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

import com.example.sbapp02.model.Employee;
import com.example.sbapp02.service.EmployeeService;


@RestController
@RequestMapping("api/v2")
public class EmployeeController {

	@Autowired
	EmployeeService employeeservice;
	
	@PostMapping("insertEmployee")
	Employee insertEmployee(@RequestBody Employee employee) {
		return employeeservice.insertEmployee(employee);
	}
	
	//Get All Employees
	@GetMapping("/getAllEmployees")
	List<Employee> getAllEmployees(){
		return employeeservice.getAllEmployees();
	}

	//Get Employee By ID
	@GetMapping("getEmployeeById/{eid}")
	Employee getEmployeeById(@PathVariable("eid") long eid) {
		return employeeservice.getEmployeeById(eid);
	}
	
	//Get Employee By Name
	@GetMapping("getEmployeeByName/{name}")
	List<Employee> getEmployeeByEage(@PathVariable("name") String name) {
		return employeeservice.getEmployeeByName(name);
	}
	
	@PatchMapping("updateEmployeeById/{eid}")
	Employee updateEmployee(@RequestBody Employee employee , @PathVariable("eid") int eid) {
		 
		Employee existEmployee = employeeservice.getEmployeeById(eid);
		existEmployee.setEage(employee.getEage());
		existEmployee.setEcity(employee.getEcity());
		existEmployee.setEname(employee.getEname());
		existEmployee.setEphone(employee.getEphone());
		existEmployee.setEsal(employee.getEsal());
		
		return employeeservice.updateEmployee(existEmployee);
	}
	
	//Delete Employee
	@DeleteMapping("deleteEmployee/{eid}")
	String deleteEmployee(@PathVariable("eid") int eid) {
		return employeeservice.deleteEmployee(eid);
		
	}
}

//		JPA says what should happen, Hibernate actually does it.
		
//		POST Request (Client)
//        │
//        ▼
//   EmployeeController (insertEmployee)
//        │
//        ▼
//  EmployeeService (insertEmployee)
//        │
//        ▼
//  EmployeeRepo.save()  (Spring Data JPA)
//        │
//        ▼
//  Hibernate (Object → SQL)
//        │
//        ▼
//  MySQL Database (employee9 table)
	
	//**************************************************************************
//	Client (UI / Postman)
//    │
//    ▼
//EmployeeController (getAllEmployees)
//    │
//    ▼
//EmployeeService (getAllEmployees)
//    │
//    ▼
//EmployeeRepo.findAll()  (Spring Data JPA)
//    │
//    ▼
//Hibernate (SQL SELECT * FROM employee9)
//    │
//    ▼
//MySQL Database (employee9 table)
//    │
//    ▼
//Hibernate converts rows → Employee objects
//    │
//    ▼
//Service → Controller → JSON → Client
//********************************************************************************************
//	JPA = Java Persistence API
//
//			It’s a specification (interface/contract) for ORM (Object-Relational Mapping) in Java.
//
//			Defines rules, annotations, and interfaces like:
//
//			@Entity, @Id, @Table, @Column
//
//			EntityManager, EntityTransaction
//
//			@OneToMany, @ManyToOne relationships
//
//			It doesn’t do actual database work — it only defines how Java objects map to DB tables.
//
//			You need a JPA implementation to actually interact with the database.
//			
//			**********Hibernate**********************
//			
//			Hibernate = JPA implementation + extra features
//
//			It is a library/framework that implements the JPA specification.
//
//			It does the actual work of:
//
//			Generating SQL
//
//			Executing queries
//
//			Mapping database rows to Java objects
//
//			Managing sessions, transactions, caching
//
//			Hibernate can be used as JPA implementation
	
//	JPA = contract / blueprint
//
//			Hibernate = worker / engine / implementation
//	
//	JPA = the standard Java way to map Java objects to database tables (specification).
//			Hibernate = one implementation of JPA that does the actual work and adds extra features.

