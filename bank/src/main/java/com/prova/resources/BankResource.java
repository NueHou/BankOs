package com.prova.resources;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prova.services.BankService;

@RestController
@RequestMapping(value = "/bank")
public class BankResource {

    @Autowired
    private BankService bankService;

    
}
