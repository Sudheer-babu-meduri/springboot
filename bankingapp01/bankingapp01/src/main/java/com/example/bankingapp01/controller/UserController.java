package com.example.bankingapp01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bankingapp01.service.AccountService;

@RestController
@RequestMapping("/user")
public class UserController {

	 @Autowired
	    private AccountService service;

	    @PostMapping("/deposit")
	    public String deposit(@RequestParam Long userId,
	                          @RequestParam Double amount) {
	        service.deposit(userId, amount);
	        return "Deposited";
	    }

	    @PostMapping("/withdraw")
	    public String withdraw(@RequestParam Long userId,
	                           @RequestParam Double amount) {
	        service.withdraw(userId, amount);
	        return "Withdrawn";
	    }
}