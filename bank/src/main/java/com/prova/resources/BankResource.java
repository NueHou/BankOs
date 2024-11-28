package com.prova.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.prova.domains.Bank;
import com.prova.dtos.BankDTO;
import com.prova.services.BankService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/bank")
@Tag(name = "Bank", description = "API para gerenciamento de Bancos")
public class BankResource {

    @Autowired
    private BankService bankService;

    @Operation(summary = "Lista todos os Bancos", description = "Retorna uma lista com todos os Bancos")
    @GetMapping
    public ResponseEntity<List<BankDTO>> findAll(){
        return ResponseEntity.ok().body(bankService.findAll());
    }

    @PostMapping
    public ResponseEntity<BankDTO> create(@Valid@RequestBody BankDTO objDto){
        Bank newObj = bankService.create(null, objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @Operation(summary = "Lista por Id", description = "Retorna Por Id")
    @GetMapping(value = "/bank/id/{id}")
    public ResponseEntity<BankDTO> findById(@PathVariable Integer id){
        Bank obj = this.bankService.findById(id);
        return ResponseEntity.ok().body(new BankDTO(obj));
    }


    @Operation(summary = "Lista por Cnpj", description = "Retorna por Cnpj")
    @GetMapping(value = "/bank/cnpj/{cnpj}")
    public ResponseEntity<BankDTO> findByCnpj(@PathVariable String cnpj){
        Bank obj = this.bankService.findByCnpj(cnpj);
        return ResponseEntity.ok().body(new BankDTO(obj));
    }

    @DeleteMapping
    public ResponseEntity<BankDTO> delete(@PathVariable Integer id){
        bankService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
