package com.example.bankingapp01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bankingapp01.entity.Loan;
import com.example.bankingapp01.entity.User;
import com.example.bankingapp01.exceptions.ResourceNotFoundException;
import com.example.bankingapp01.repo.LoanRepository;
import com.example.bankingapp01.repo.UserRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private LoanRepository repo;

    @PostMapping("/approve/{id}")
    public String approve(@PathVariable Long id) {

        Loan loan = repo.findById(id).orElseThrow(()->new ResourceNotFoundException("ID Not found with "+id));

        loan.setStatus("APPROVED");
        repo.save(loan);

        return "Loan Approved";
    }
    
    @Autowired
    private UserRepository userrepo;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userrepo.findAll();
    }
}