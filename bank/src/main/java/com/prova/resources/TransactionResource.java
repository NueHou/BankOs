package com.prova.resources;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prova.domains.Transaction;
import com.prova.dtos.TransactionDTO;
import com.prova.services.TransactionService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/transaction")
@Tag(name = "Transaction", description = "API de gerenciamento para Transações")
public class TransactionResource {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public ResponseEntity<List<TransactionDTO>> findAll(){
        return ResponseEntity.ok().body(transactionService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TransactionDTO> findById(@PathVariable UUID id){
        Transaction obj = this.transactionService.findById(id);
        return ResponseEntity.ok().body(new TransactionDTO(obj));
    }
}
