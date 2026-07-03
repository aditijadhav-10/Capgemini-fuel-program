package com.example.Spring5.controller;

import com.example.Spring5.model.Account;
import com.example.Spring5.serviceimpl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{acc}")
public class AccountController {

    @Autowired
    private AccountServiceImpl accountService;

    @PostMapping
    public Account CreateAccount(@RequestBody Account account)
    {
        return accountService.saveAccount(account);
    }

    @GetMapping("{id}")
    public Account getAccount(@PathVariable Long id)
    {
        return accountService.getAccount(id);
    }

    @PutMapping("/{id}/{amount}")
    public Account updateAccount(@PathVariable Long id,@PathVariable double amount){
        return accountService.updateAccount(id,amount);

    }

    @DeleteMapping("{id}")
    public String deleteAccount(@PathVariable Long id)
    {
        accountService.deleteAccount(id);
        return "Here Account data is deleted successfully ...."+id;
    }
}
