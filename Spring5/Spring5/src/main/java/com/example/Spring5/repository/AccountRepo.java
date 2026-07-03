package com.example.Spring5.repository;

import com.example.Spring5.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepo extends JpaRepository<Account,Long> {
    Optional<Account> findAccountByAccountholder(String accountholder);

}
