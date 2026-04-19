package com.example.bankingapp01.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bankingapp01.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUserId(Long userId);

}
