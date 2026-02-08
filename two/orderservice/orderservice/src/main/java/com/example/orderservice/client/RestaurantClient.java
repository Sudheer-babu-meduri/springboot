package com.example.orderservice.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.orderservice.response.FoodItems;
import com.example.orderservice.response.Restaurant;


@FeignClient(name = "restaurantservice" ,url="http://localhost:9999/api/v1")
public interface RestaurantClient  {

	
	@GetMapping("getRes/{id}")
	public  Restaurant getRestaurant(@PathVariable int id);
	
	@GetMapping("getFoodItems/{id}")
	public List<FoodItems> getFoodItems(@PathVariable int id);
}



//🧱 1️⃣ Using Spring Framework (WITHOUT Spring Boot)
//
//This needs manual configuration.
//
//✅ Step 1: Student Model
//public class Student {
//    private int id;
//    private String name;
//
//    // getters and setters
//}
//
//✅ Step 2: Controller
//import org.springframework.web.bind.annotation.*;
//import java.util.*;
//
//@RestController
//public class StudentController {
//
//    private List<Student> students = new ArrayList<>();
//
//    @PostMapping("/students")
//    public String addStudent(@RequestBody Student student) {
//        students.add(student);
//        return "Student added";
//    }
//
//    @GetMapping("/students")
//    public List<Student> getStudents() {
//        return students;
//    }
//}
//
//❗ Step 3: Manual Spring Configuration
//🔹 web.xml (DispatcherServlet setup)
//<web-app>
//    <servlet>
//        <servlet-name>spring</servlet-name>
//        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
//    </servlet>
//
//    <servlet-mapping>
//        <servlet-name>spring</servlet-name>
//        <url-pattern>/</url-pattern>
//    </servlet-mapping>
//</web-app>
//
//🔹 spring-servlet.xml (Component Scan)
//<context:component-scan base-package="com.example" />
//<mvc:annotation-driven/>
//
//❗ Step 4: Build WAR & Deploy
//
//You must:
//
//Build WAR file
//
//Deploy into external Tomcat server
//
//🚀 2️⃣ Same Application Using Spring Boot
//
//Now see how simple this becomes.
//
//✅ Step 1: Main Class
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class StudentApp {
//    public static void main(String[] args) {
//        SpringApplication.run(StudentApp.class, args);
//    }
//}
//
//✅ Step 2: Student Model (Same as before)
//public class Student {
//    private int id;
//    private String name;
//
//    // getters and setters
//}
//
//✅ Step 3: Controller (Same logic)
//import org.springframework.web.bind.annotation.*;
//import java.util.*;
//
//@RestController
//@RequestMapping("/students")
//public class StudentController {
//
//    private List<Student> students = new ArrayList<>();
//
//    @PostMapping
//    public String addStudent(@RequestBody Student student) {
//        students.add(student);
//        return "Student added";
//    }
//
//    @GetMapping
//    public List<Student> getStudents() {
//        return students;
//    }
//}
//
//🧱 1️⃣ Using Spring Framework (WITHOUT Spring Boot)
//
//This needs manual configuration.
//
//✅ Step 1: Student Model
//public class Student {
//    private int id;
//    private String name;
//
//    // getters and setters
//}
//
//✅ Step 2: Controller
//import org.springframework.web.bind.annotation.*;
//import java.util.*;
//
//@RestController
//public class StudentController {
//
//    private List<Student> students = new ArrayList<>();
//
//    @PostMapping("/students")
//    public String addStudent(@RequestBody Student student) {
//        students.add(student);
//        return "Student added";
//    }
//
//    @GetMapping("/students")
//    public List<Student> getStudents() {
//        return students;
//    }
//}
//
//❗ Step 3: Manual Spring Configuration
//🔹 web.xml (DispatcherServlet setup)
//<web-app>
//    <servlet>
//        <servlet-name>spring</servlet-name>
//        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
//    </servlet>
//
//    <servlet-mapping>
//        <servlet-name>spring</servlet-name>
//        <url-pattern>/</url-pattern>
//    </servlet-mapping>
//</web-app>
//
//🔹 spring-servlet.xml (Component Scan)
//<context:component-scan base-package="com.example" />
//<mvc:annotation-driven/>
//
//❗ Step 4: Build WAR & Deploy
//
//You must:
//
//Build WAR file
//
//Deploy into external Tomcat server
//
//🚀 2️⃣ Same Application Using Spring Boot
//
//Now see how simple this becomes.
//
//✅ Step 1: Main Class
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class StudentApp {
//    public static void main(String[] args) {
//        SpringApplication.run(StudentApp.class, args);
//    }
//}
//
//✅ Step 2: Student Model (Same as before)
//public class Student {
//    private int id;
//    private String name;
//
//    // getters and setters
//}
//
//✅ Step 3: Controller (Same logic)
//import org.springframework.web.bind.annotation.*;
//import java.util.*;
//
//@RestController
//@RequestMapping("/students")
//public class StudentController {
//
//    private List<Student> students = new ArrayList<>();
//
//    @PostMapping
//    public String addStudent(@RequestBody Student student) {
//        students.add(student);
//        return "Student added";
//    }
//
//    @GetMapping
//    public List<Student> getStudents() {
//        return students;
//    }
//}

//▶️ Step 4: Run
//
//Just run the main method.
//
//Embedded Tomcat starts automatically:
//
//Tomcat started on port 8080
//
//
//No WAR. No web.xml. No server setup.
//
//⚡ MAIN DIFFERENCES YOU JUST SAW
//Feature	Spring (Old Way)	Spring Boot
//DispatcherServlet	You configure manually	Auto-configured
//XML Files	Required	Not needed
//Server	External Tomcat needed	Embedded Tomcat
//Project Packaging	WAR	JAR
//Start App	Deploy to server	Run main()
//Dependency Setup	Manual	Starter dependencies
//🧠 What Actually Happened Behind the Scenes?
//
//Spring Boot automatically did what you had to manually do in Spring:
//
//Manual in Spring	Done Automatically by Spring Boot
//Create DispatcherServlet	✅
//Enable component scan	✅
//Configure Jackson JSON	✅
//Setup embedded Tomcat	✅
//Configure Spring MVC	✅
//🎯 Final One-Line Difference
//
//Spring Boot removes all the setup pain of Spring and lets you focus only on writing business logic.
//
//If you want, next we can connect this app to a database (MySQL/JPA) in both versions — then the difference becomes even more obvious 😄
//
//web.xml (DispatcherServlet setup)
//<web-app>
//    <servlet>
//        <servlet-name>spring</servlet-name>
//        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
//    </servlet>
//
//    <servlet-mapping>
//        <servlet-name>spring</servlet-name>
//        <url-pattern>/</url-pattern>
//    </servlet-mapping>
//</web-app>
//
//🔹 spring-servlet.xml (Component Scan)
//<context:component-scan base-package="com.example" />
//<mvc:annotation-driven/>
//
//❗ Step 4: Build WAR & Deploy
//
//You must:
//
//Build WAR file
//
//Deploy into external Tomcat server
//please explain these steps
//
//Perfect — this is the core pain Spring Boot removed. Let’s break these old-school Spring steps in a simple, practical way.
//
//📄 1️⃣ web.xml — Registering the Front Controller
//💡 What is happening here?
//
//web.xml is the deployment descriptor for traditional Java web apps.
//
//You are telling the server:
//
//“Hey Tomcat, whenever a request comes, send it to Spring.”
//
//Code Breakdown
//<servlet>
//    <servlet-name>spring</servlet-name>
//    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
//</servlet>
//
//
//🔹 This creates DispatcherServlet
//👉 DispatcherServlet = Front Controller of Spring MVC
//It handles all incoming HTTP requests
//
//<servlet-mapping>
//    <servlet-name>spring</servlet-name>
//    <url-pattern>/</url-pattern>
//</servlet-mapping>
//
//
//🔹 This means:
//Every URL like
///students
///login
///anything
//➡ goes first to DispatcherServlet
//
//Without this file, Spring MVC won’t even start.
//
//📄 2️⃣ spring-servlet.xml — Telling Spring What to Scan
//
//This file is Spring’s configuration file.
//
//<context:component-scan base-package="com.example" />
//
//
//🔹 Spring will scan this package to find:
//
//@Controller
//
//@RestController
//
//@Service
//
//@Repository
//
//@Component
//
//If you forget this → your controller will not be detected ❌
//
//<mvc:annotation-driven/>
//
//
//🔹 This enables:
//
//@RequestMapping
//
//@GetMapping
//
//@PostMapping
//
//JSON conversion (Jackson)
//
//Validation
//
//Without this → your REST endpoints won’t work properly.
//
//🧱 3️⃣ Build WAR File
//
//In traditional Spring, we don’t run main().
//
//We package the project as a WAR (Web Archive) file.
//
//In Maven:
//<packaging>war</packaging>
//
//
//Then run:
//
//mvn clean package
//
//
//You get:
//
//studentapp.war
//
//
//WAR = App that needs a separate server to run.
//
//🖥 4️⃣ Deploy WAR into External Tomcat
//
//Steps:
//
//Install Tomcat server
//
//Go to Tomcat folder → webapps
//
//Copy studentapp.war into webapps
//
//Start Tomcat
//
//Tomcat extracts WAR → runs app
//
//Then access:
//
//http://localhost:8080/studentapp/students
//
//🔥 Now Compare with Spring Boot
//Traditional Spring	Spring Boot
//You create web.xml	❌ Not needed
//You configure DispatcherServlet	❌ Auto-configured
//You write XML config	❌ Not required
//You build WAR	❌ Builds executable JAR
//You install Tomcat	❌ Embedded Tomcat
//You deploy manually	❌ Just run main()
//🧠 Big Picture
//
//In old Spring you must:
//
//Register Spring with the server (web.xml)
//
//Tell Spring where your code is (component-scan)
//
//Enable MVC features (annotation-driven)
//
//Package as WAR
//
//Deploy into server
//
//Spring Boot does all 5 automatically.
//
//If you understand this flow, you now understand why Spring Boot was created 💯
//
//Want me to show how Boot internally replaces web.xml?
//
//what You write in XML config
//
//Nice — this is the heart of old Spring configuration.
//In XML config, you basically tell Spring what objects to create and how to connect them.
//
//Let’s keep it simple and practical 👇
//
//📄 What Do We Write in Spring XML Configuration?
//
//Mainly 3 types of things:
//
//1️⃣ Component Scanning
//2️⃣ MVC Setup
//3️⃣ Bean Definitions (Manual Object Creation)
//
//1️⃣ Component Scanning (Find Your Classes)
//<context:component-scan base-package="com.example" />
//
//What it does:
//
//Spring searches this package for classes with:
//
//@Controller
//
//@Service
//
//@Repository
//
//@Component
//
//👉 Without this, Spring won’t know your classes exist
//
//2️⃣ Enable Spring MVC Features
//<mvc:annotation-driven/>
//
//
//This enables:
//✔ @RequestMapping, @GetMapping, @PostMapping
//✔ JSON conversion (Object → JSON using Jackson)
//✔ Form validation
//
//Without this → REST APIs won’t work correctly ❌
//
//3️⃣ Bean Definitions (Old Way of Creating Objects)
//
//Before annotations were popular, we created objects manually in XML.
//
//Example: Service & Repository
//<bean id="studentService" class="com.example.service.StudentService">
//    <property name="studentRepository" ref="studentRepository"/>
//</bean>
//
//<bean id="studentRepository" class="com.example.repository.StudentRepository"/>
//
//What’s happening?
//
//Spring is doing this for you:
//
//StudentRepository repo = new StudentRepository();
//StudentService service = new StudentService();
//service.setStudentRepository(repo);
//
//
//This is called Dependency Injection using XML.
//
//4️⃣ View Resolver (For JSP Projects)
//
//If using JSP pages:
//
//<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
//    <property name="prefix" value="/WEB-INF/views/" />
//    <property name="suffix" value=".jsp" />
//</bean>
//
//
//This tells Spring:
//If controller returns "home"
//👉 Show /WEB-INF/views/home.jsp
//
//(Not needed for REST APIs)
//
//5️⃣ DataSource (Database Connection Example)
//<bean id="dataSource" class="org.apache.commons.dbcp2.BasicDataSource">
//    <property name="driverClassName" value="com.mysql.cj.jdbc.Driver"/>
//    <property name="url" value="jdbc:mysql://localhost:3306/studentdb"/>
//    <property name="username" value="root"/>
//    <property name="password" value="root"/>
//</bean>
//
//
//This creates a database connection bean.
//
//🧠 Summary — XML Config = Instructions to Spring
//Purpose	XML Tag
//Scan your code	<context:component-scan>
//Enable MVC	<mvc:annotation-driven/>
//Create objects	<bean>
//Connect objects	<property ref="">
//Setup views	InternalResourceViewResolver
//Setup database	DataSource bean
//🔥 Why This Feels Heavy
//
//You must:
//
//Write object creation manually
//
//Wire dependencies manually
//
//Configure MVC manually
//
//Configure DB manually
//
//👉 Spring Boot removed almost all of this using auto-configuration + properties file
//
//🎯 One-Line Understanding
//
//Spring XML config = Manual instructions telling Spring what objects to create and how to connect them.