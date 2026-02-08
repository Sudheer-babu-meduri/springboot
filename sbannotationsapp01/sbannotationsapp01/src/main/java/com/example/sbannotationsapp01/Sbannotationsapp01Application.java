package com.example.sbannotationsapp01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Sbannotationsapp01Application {

	public static void main(String[] args) {
		System.out.println("main method started");
		ConfigurableApplicationContext context =SpringApplication.run(Sbannotationsapp01Application.class, args);
		
		Student st1 = context.getBean(Student.class);
		
		System.out.println(st1.id);
		System.out.println(st1.name);
		System.out.println(st1.age);
		st1.computer.show();
		System.out.println("main method ended");
		
	}

}
//Caused by: org.springframework.beans.factory.NoSuchBeanDefinitionException: 
//	No qualifying bean of type 'com.example.sbannotationsapp01.Student' available
//becaue we didn't give @Component for Student class

//NullPointerException because computer object is null  
//after trying @Autowired in setComputer it is gone

//org.springframework.beans.factory.UnsatisfiedDependencyException: 
//Error creating bean with name 'student': Unsatisfied dependency expressed through
//method 'setName' parameter 0: No qualifying bean of type 'java.lang.String' available: 
//expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {}
// because we didn't give @Component in Laptop and Desktop

//org.springframework.beans.factory.UnsatisfiedDependencyException: 
//Error creating bean with name 'student': Unsatisfied dependency expressed through method 'setComputer'
//parameter 0: No qualifying bean of type 'com.example.sbannotationsapp01.Computer' available:
//expected single matching bean but found 2: desktop ,laptop
// after giving @Primary at Laptop class then it will give laptop object method

//what happens if we give @Primary for both classes???
//we get NoUniqueBeanDefinitionException
//then give @Qualifier("laptop") at setComputer beside the @Autowired
