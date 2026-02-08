package com.example.springbootms01.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootms01.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{
 
}
