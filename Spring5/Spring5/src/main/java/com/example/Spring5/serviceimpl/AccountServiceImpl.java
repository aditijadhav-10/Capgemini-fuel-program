package com.example.Spring5.serviceimpl;

import com.example.Spring5.exception.AccountNotFoundException;
import com.example.Spring5.exception.InsufficientBalanceException;
import com.example.Spring5.model.Account;
import com.example.Spring5.repository.AccountRepo;
import com.example.Spring5.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepo accountRepo;

    @Override
    public Account saveAccount(Account account) {
        return accountRepo.save(account);
    }

    @Override
    public Account getAccount(Long id) {
        return accountRepo.findById(id).orElseThrow(()-> new AccountNotFoundException("Account Not Found:"+id));
    }

    @Override
    public Account updateAccount(Long id, double amount) {
            Account account = accountRepo.findById(id)
                    .orElseThrow(() ->
                            new AccountNotFoundException("Account not found with id: " + id));

            if (account.getBalance() < amount) {
                throw new InsufficientBalanceException(
                        "Insufficient balance. Available Balance: " + account.getBalance());
            }

            account.setBalance(account.getBalance() - amount);

            return accountRepo.save(account);
        }

    @Override
    public void deleteAccount(Long id) {
        accountRepo.deleteById(id);
    }

}


