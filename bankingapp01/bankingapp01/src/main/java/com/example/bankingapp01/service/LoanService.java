package com.example.bankingapp01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bankingapp01.entity.Account;
import com.example.bankingapp01.entity.Loan;
import com.example.bankingapp01.repo.AccountRepository;
import com.example.bankingapp01.repo.LoanRepository;

@Service
public class LoanService {

	 @Autowired
	    private AccountRepository accountRepo;

	    @Autowired
	    private LoanRepository loanRepo;

	    public String applyLoan(Long userId, Double amount) {

	        Account acc = accountRepo.findByUserId(userId).orElseThrow();

	        // ⭐ RULE
	        if (acc.getBalance() < 10000) {
	            return "Loan Rejected: Minimum balance must be 10000";
	        }

	        Loan loan = new Loan();
	        loan.setAmount(amount);
	        loan.setStatus("PENDING");
	        loan.setUser(acc.getUser());

	        loanRepo.save(loan);

	        return "Loan Applied Successfully";
	    }
}
