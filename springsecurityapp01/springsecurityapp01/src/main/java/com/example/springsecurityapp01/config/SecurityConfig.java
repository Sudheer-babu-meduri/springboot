package com.example.springsecurityapp01.config;
	
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
 
	 
//		pe is your BCryptPasswordEncoder.
//
//		This means Spring stores the hashed password, not "meduri123".
//
//		When the user logs in and enters meduri123, Spring hashes that input 
//		and compares it to the stored hash.
		
//		They send their plain password "meduri123" in the request.
//
//		Spring Security takes the password, hashes it again using BCrypt.
//
//		It then compares the newly hashed value with the stored hash.
	@Bean
	public UserDetailsService userDetailService(PasswordEncoder pe) {
		
		var UserDetailsManager = new InMemoryUserDetailsManager();
		
		UserDetails user = User.builder()
				   .username("meduri")
				   .password(pe.encode("meduri123"))
				   .roles("USER")
				   .build();
		
		UserDetails admin = User.builder()
				    .username("sudheer")
				    .password(pe.encode("sudheer123"))
				    .roles("ADMIN")
				    .build();
		
		UserDetailsManager.createUser(user);
		UserDetailsManager.createUser(admin);
		
		return UserDetailsManager;
	}
	
	@Bean
	public PasswordEncoder getPass() {
		return new BCryptPasswordEncoder();  //BCryptPasswordEncoder hashes the password.
	}
	
	@Bean
	public SecurityFilterChain getSecurity(HttpSecurity http) throws Exception{
		
	     return http 
	    		 .csrf(c->c.disable())
	    		 .authorizeHttpRequests(auth->auth
	    				 .requestMatchers("/api/v1/public").permitAll()
	    				 .requestMatchers("/api/v1/user").hasRole("USER")
	    				 .requestMatchers("/api/v1/admin").hasRole("ADMIN")
	    				 .anyRequest().authenticated()
	    				 )
	    		      .httpBasic(Customizer.withDefaults())
	    		      .build();
		
	}
	
}
