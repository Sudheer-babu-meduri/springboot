package com.example.bankingapp01.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bankingapp01.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}