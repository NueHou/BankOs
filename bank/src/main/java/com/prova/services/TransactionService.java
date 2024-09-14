package com.prova.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prova.dtos.TransactionDTO;
import com.prova.repositories.TransactionRepository;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepo;

    public List<TransactionDTO> findAll(){
        return transactionRepo.findAll().stream().map(obj -> new TransactionDTO()).collect(Collectors.toList());
    }

}
