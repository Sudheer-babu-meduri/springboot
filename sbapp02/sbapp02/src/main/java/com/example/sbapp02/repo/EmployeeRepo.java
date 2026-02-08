package com.example.sbapp02.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sbapp02.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{

	List<Employee> findByEname(String name);
	
}
