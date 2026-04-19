package com.example.bankingapp01.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bankingapp01.entity.Account;
import com.example.bankingapp01.exceptions.InsufficientBalance;
import com.example.bankingapp01.exceptions.ResourceNotFoundException;
import com.example.bankingapp01.repo.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repo;

    public void deposit(Long userId, Double amount) {

        Account acc = repo.findByUserId(userId).orElseThrow();

        acc.setBalance(acc.getBalance() + amount);
        repo.save(acc);
    }

    public void withdraw(Long userId, Double amount) {

    	Account acc = repo.findByUserId(userId)
    	        .orElseThrow(() -> new ResourceNotFoundException("Account not found for userId: " + userId));
    	
        if (acc.getBalance() < amount)
            throw new InsufficientBalance("Insufficient balance");

        acc.setBalance(acc.getBalance() - amount);
        repo.save(acc);
    }
}
