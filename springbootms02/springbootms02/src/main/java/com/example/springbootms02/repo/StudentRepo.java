package com.example.springbootms02.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootms02.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{

}
