package com.example.sbannotationsapp01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {

	@Value("7")
	int id;
	
	@Value("Thala")
	String name;
	
	@Value("37")
	int age;
	Computer computer;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Computer getComputer() {
		return computer;
	}
	
	@Autowired
	@Qualifier("laptop")
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
