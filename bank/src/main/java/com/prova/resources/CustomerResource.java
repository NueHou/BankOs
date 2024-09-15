package com.prova.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.prova.domains.Customer;
import com.prova.dtos.CustomerDTO;
import com.prova.services.CustomerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/customer")
@Tag(name = "Customer", description = "APi para gerenciamento de Clientes")
public class CustomerResource {

    @Autowired
    private CustomerService customerService;

    @Operation(summary = "Lista todos os Clientes", description = "Retorna todos os clientes")
    @GetMapping
    public ResponseEntity<List<CustomerDTO>> findAll(){
        return ResponseEntity.ok().body(customerService.findAll());
    }

    @Operation(summary = "Lista Por ID", description = "Lista cliente pela ID")
    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomerDTO> findById(@PathVariable Integer id){
        Customer obj = this.customerService.findById(id);
        return ResponseEntity.ok().body(new CustomerDTO(obj));
    }

    @Operation(summary = "Lista por CPF", description = "Lista Clientes por CPF")
    @GetMapping(value = "/{cpf}")
    public ResponseEntity<CustomerDTO> findByCpf(@PathVariable String cpf){
        Customer obj = this.customerService.findByCpf(cpf);
        return ResponseEntity.ok().body(new CustomerDTO(obj));
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> create(@Valid@RequestBody CustomerDTO obDto, Integer id){
        Customer newObj = customerService.create(id, obDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> update(@PathVariable Integer id, @Valid @RequestBody CustomerDTO objDto){
        Customer obj = customerService.update(id, objDto);
        return ResponseEntity.ok().body(new CustomerDTO(obj));
    }

    @DeleteMapping
    public ResponseEntity<CustomerDTO> delete(@PathVariable Integer id){
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }
        
    

}
