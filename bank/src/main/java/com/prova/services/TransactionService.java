package com.prova.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.prova.domains.Customer;
import com.prova.domains.Transaction;
import com.prova.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prova.domains.dtos.TransactionDTO;
import com.prova.repositories.TransactionRepository;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepo;

    public List<TransactionDTO> findAll(){
        return transactionRepo.findAll().stream().map(obj -> new TransactionDTO(obj)).collect(Collectors.toList());
    }

    
    

}
