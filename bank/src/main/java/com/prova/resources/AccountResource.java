package com.prova.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prova.domains.Account;
import com.prova.dtos.AccountDTO;
import com.prova.services.AccountService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/account")
@Tag(name = "Account", description = "APi para gerenciamento de Contas bancarias")
public class AccountResource {

    @Autowired
    private AccountService accountService;

    @Operation(summary = "Lista todas as Contas", description = "Retorna todas as contas existentes")
    @GetMapping
    public ResponseEntity <List<AccountDTO>> findAll(){
        return ResponseEntity.ok().body(accountService.findAll());
    }

    @Operation(summary = "Lista por ID", description = "Retorna por ID")
    @GetMapping(value = "/{id}")
    public ResponseEntity<AccountDTO> findById(@PathVariable Integer id){
        Account obj = this.accountService.findById(id);
        return ResponseEntity.ok().body(new AccountDTO(obj));
    }

}
