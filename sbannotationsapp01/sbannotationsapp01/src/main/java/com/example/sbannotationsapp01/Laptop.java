package com.example.sbannotationsapp01;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Laptop implements Computer{

	@Override
	public void show() {
        System.out.println("Laptop show() method called");		
	}

	
}
