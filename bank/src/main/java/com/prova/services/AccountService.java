package com.prova.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prova.dtos.AccountDTO;
import com.prova.repositories.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepo;

    public List<AccountDTO> findAll(){
        return accountRepo.findAll().stream().map(obj -> new AccountDTO()).collect(Collectors.toList());
    }
}
