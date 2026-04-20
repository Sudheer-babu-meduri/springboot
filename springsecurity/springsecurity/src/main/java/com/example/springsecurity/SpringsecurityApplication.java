package com.example.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringsecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityApplication.class, args);
	}

}
SpringApplication.run(MyApplication.class, args);

//1️⃣ What SpringApplication.run() is
//
//SpringApplication.run() is the starting point of a Spring Boot application.
//
//Think of it as “turning on the engine of your Spring Boot app”.
//
//It does many things internally to start your app.
//
//2️⃣ Step-by-Step What Happens Internally
//
//When you call:
//
//SpringApplication.run(MyApplication.class, args);
//
//Spring Boot does these major steps:
//
//Step 1: Create SpringApplication object
//SpringApplication app = new SpringApplication(MyApplication.class);
//
//It reads your main class (MyApplication)
//
//Checks for annotations like @SpringBootApplication, @EnableAutoConfiguration, etc.
//
//Step 2: Starts Spring Context (IOC container)
//ConfigurableApplicationContext context = app.run(args);
//
//Creates ApplicationContext (Spring container)
//
//Scans packages for components (@Component, @Service, @Repository, @Controller)
//
//Creates beans and wires them (Dependency Injection)
//
//Reads configuration (application.properties / application.yml)
//
//Runs Auto-Configuration (@EnableAutoConfiguration)
//
//Step 3: Run Embedded Web Server (if it’s a web app)
//
//Spring Boot starts Tomcat / Jetty / Undertow automatically
//
//Deploys your controllers (@RestController / @Controller)
//
//Now your app can accept HTTP requests
//
//Step 4: Run Application Events / Listeners
//
//Spring Boot fires events like ApplicationStartedEvent, ApplicationReadyEvent
//
//You can listen to these events if needed
//
//3️⃣ Example: What it allows you to do
//@SpringBootApplication
//public class MyApplication {
//    public static void main(String[] args) {
//        SpringApplication.run(MyApplication.class, args);
//    }
//}
//
//When you run this:
//
//Spring Boot creates IOC container
//
//Scans your components
//
//Starts embedded Tomcat
//
//Your controllers are ready to accept HTTP requests
//
//Application is fully running 🎉
