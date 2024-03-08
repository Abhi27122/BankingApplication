package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Account;
import com.example.demo.repo.AccountRepo;

@RestController
public class AccountController {

    @Autowired
    private AccountRepo accountRepo;

    @GetMapping("/login")
    public boolean login(@RequestParam String customerId, @RequestParam String password) {
        return accountRepo.existsByCustomerIdAndPassword(customerId, password);
    }

    @PostMapping("/register")
    public void register(@RequestBody Account account) {
        accountRepo.save(account);
    }

    @PutMapping("/changepwd/{customerId}/{oldPassword}/{newPassword}")
    public void changePassword(@PathVariable String customerId,
                               @PathVariable String oldPassword,
                               @PathVariable String newPassword) {
        Account account = accountRepo.findByCustomerIdAndPassword(customerId, oldPassword);
        if (account != null) {
            account.setPassword(newPassword);
            accountRepo.save(account);
        }
    }

    @PostMapping("/transfer")
    public void transfer(@RequestParam int fromAccountNo,
                         @RequestParam int toAccountNo,
                         @RequestParam double amount) {
        Account fromAccount = accountRepo.findByAccountNo(fromAccountNo);
        Account toAccount = accountRepo.findByAccountNo(toAccountNo);

        if (fromAccount != null && toAccount != null && fromAccount.getAmount() >= amount) {
            fromAccount.setAmount(fromAccount.getAmount() - amount);
            toAccount.setAmount(toAccount.getAmount() + amount);
            accountRepo.save(fromAccount);
            accountRepo.save(toAccount);
        } else {
            throw new IllegalArgumentException("Insufficient balance or invalid accounts");
        }
    }

    @GetMapping("/balance/{accountNo}")
    public double getBalance(@PathVariable int accountNo) {
        Account account = accountRepo.findByAccountNo(accountNo);
        return (account != null) ? account.getAmount() : 0.0;
    }

    @GetMapping("/accounts/below")
    public Iterable<Account> getAccountsBelow(@RequestParam double amount) {
        return accountRepo.findByAmountLessThan(amount);
    }

    @GetMapping("/accounts/above")
    public Iterable<Account> getAccountsAbove(@RequestParam double amount) {
        return accountRepo.findByAmountGreaterThan(amount);
    }
}
