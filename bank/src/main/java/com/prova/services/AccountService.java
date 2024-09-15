package com.prova.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prova.domains.Account;
import com.prova.dtos.AccountDTO;
import com.prova.repositories.AccountRepository;
import com.prova.services.exceptions.ObjectNotFoundException;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepo;

    public List<AccountDTO> findAll(){
        return accountRepo.findAll().stream().map(obj -> new AccountDTO()).collect(Collectors.toList());
    }

    public Account findById(Integer id){
        Optional<Account> obj = accountRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não Encontrado! Id:"+id));
    }
    
}
