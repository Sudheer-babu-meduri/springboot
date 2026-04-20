package com.example.springsecurityapp02.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
 
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public UserDetailsService userDetailsService() {
		   UserDetails user = User.withDefaultPasswordEncoder()
				               .username("user")
				               .password("7777")
				               .roles("USER")
				               .build();
		   
		   UserDetails admin = User.withDefaultPasswordEncoder()
	               .username("admin")
	               .password("6666")
	               .roles("ADMIN")
	               .build();
		   return new InMemoryUserDetailsManager(user,admin);
 	}
 
	@Bean
	public SecurityFilterChain security(HttpSecurity http)throws Exception{
		
		http.authorizeHttpRequests(auth -> auth
		     
		          .requestMatchers("/home").permitAll()
		           .requestMatchers("/admin").hasRole("ADMIN")
		           .requestMatchers("/user").hasAnyRole("USER")
		           .anyRequest().denyAll()
				);
		
		  http.httpBasic(Customizer.withDefaults());
		  return http.build();
		  
	}
	
}
