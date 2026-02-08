package com.example.sbapp02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sbapp02.model.Employee;
import com.example.sbapp02.repo.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepo employeerepo;
	
	//Insert Employee
	public Employee insertEmployee(Employee employee) {
		return employeerepo.save(employee);
	}
	
	//Get All Employees
    public List<Employee> getAllEmployees(){
    	return employeerepo.findAll();
    }
    
    //Get Emp By ID
    public Employee getEmployeeById(long eid) {
    	return employeerepo.findById(eid).orElse(null);
    }
    
    //Get Emp By name
    public List<Employee> getEmployeeByName(String name) {
    	return employeerepo.findByEname(name);
    }
    
    //Update Emp
    public Employee updateEmployee(Employee employee) {
    	return employeerepo.save(employee);
    }
    
    //Delete Emp
    public String deleteEmployee(long eid) {
    	employeerepo.deleteById(eid);
    	return "Employee "+eid+" Deleted Successfully";
    }
}
