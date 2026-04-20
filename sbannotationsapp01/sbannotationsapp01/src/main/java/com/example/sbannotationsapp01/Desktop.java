package com.example.sbannotationsapp01;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Desktop implements Computer{

	public void show() {
		System.out.println("Desktop show() method called");
	}

}
