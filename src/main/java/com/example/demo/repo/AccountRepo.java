package com.example.demo.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, String> {
    boolean existsByCustomerIdAndPassword(String customerId, String password);

    Account findByCustomerIdAndPassword(String customerId, String password);

    Account findByAccountNo(int account);

    Iterable<Account> findByAmountLessThan(double amount);

    Iterable<Account> findByAmountGreaterThan(double amount);
}
