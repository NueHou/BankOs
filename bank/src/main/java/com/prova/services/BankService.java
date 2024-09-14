package com.prova.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prova.dtos.BankDTO;
import com.prova.repositories.BankRepository;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepo;

    public List<BankDTO> findAll(){
        return bankRepo.findAll().stream().map(obj -> new BankDTO(obj)).collect(Collectors.toList());
    }

    

}
