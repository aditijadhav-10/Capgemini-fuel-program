package com.example.Spring5.service;

import com.example.Spring5.model.Account;

public interface AccountService {
    Account saveAccount(Account account);
    Account getAccount(Long id);
    Account updateAccount(Long id,double amount);
    void deleteAccount(Long id);


}
