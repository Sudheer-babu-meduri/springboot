package com.example.bankingapp01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bankingapp01.service.LoanService;

@RestController
@RequestMapping("/user/loans")
public class LoanController {

	 @Autowired
	    private LoanService service;

	    @PostMapping("/apply")
	    public String apply(@RequestParam Long userId,
	                        @RequestParam Double amount) {
	        return service.applyLoan(userId, amount);
	    }
}