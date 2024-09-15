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

import com.prova.domains.Branch;
import com.prova.dtos.BranchDTO;
import com.prova.services.BranchService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/branch")
@Tag(name = "Branch", description = "APi para gerenciamento de agencias")
public class BranchResource {

    @Autowired
    private BranchService branchService;

    @Operation(summary = "Lista todos as Agencias Bancarias", description = "Retorna Agencias")
    @GetMapping
    public ResponseEntity<List<BranchDTO>> findAll(){
        return ResponseEntity.ok().body(branchService.findAll());
    }

    @Operation(summary = "Lista Agencias por ID", description = "Retorna Agencias Por ID")
    @GetMapping(value = "/{id}")
    public ResponseEntity<BranchDTO> findById(@PathVariable Integer id){
        Branch obj = this.branchService.findById(id);
        return ResponseEntity.ok().body(new BranchDTO(obj));
    }

    @Operation(summary = "Lista agencias atraves de CNPJ", description = "Retorna atraves de CNPJ")
    @PostMapping(value = "/{cnpj}")
    public ResponseEntity<BranchDTO> findByCnpj(@PathVariable String cnpj){
        Branch obj = this.branchService.findByCnpj(cnpj);
        return ResponseEntity.ok().body(new BranchDTO(obj));
    }

    @PostMapping
    public ResponseEntity<BranchDTO> create(@Valid@RequestBody BranchDTO objDto,  Integer id){
        Branch newObj = branchService.create(id, objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping
    public ResponseEntity<BranchDTO> delete(@PathVariable Integer id){
        branchService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
