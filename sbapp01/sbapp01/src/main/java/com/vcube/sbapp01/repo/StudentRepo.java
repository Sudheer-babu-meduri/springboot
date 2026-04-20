package com.vcube.sbapp01.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vcube.sbapp01.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{
   
	Optional<Student> findBySname(String sname);
	
}