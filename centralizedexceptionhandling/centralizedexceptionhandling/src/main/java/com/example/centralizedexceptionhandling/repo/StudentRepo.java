package com.example.centralizedexceptionhandling.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.centralizedexceptionhandling.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{

}
