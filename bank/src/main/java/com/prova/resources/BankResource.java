package com.prova.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prova.domains.Bank;
import com.prova.dtos.BankDTO;
import com.prova.services.BankService;

@RestController
@RequestMapping(value = "/bank")
public class BankResource {

    @Autowired
    private BankService bankService;

    @GetMapping
    public ResponseEntity<List<BankDTO>> findAll(){
        return ResponseEntity.ok().body(bankService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BankDTO> findById(@PathVariable Integer id){
        Bank obj = this.bankService.findById(id);
        return ResponseEntity.ok().body(new BankDTO(obj));
    }

}
