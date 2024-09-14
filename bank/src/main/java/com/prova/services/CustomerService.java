package com.prova.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prova.dtos.CustomerDTO;
import com.prova.repositories.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepo;

    public List<CustomerDTO> findAll(){
        return customerRepo.findAll().stream().map(obj -> new CustomerDTO()).collect(Collectors.toList());
    }
   
    
}
