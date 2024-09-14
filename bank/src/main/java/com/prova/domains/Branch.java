package com.prova.domains;

import java.util.UUID;


import com.prova.dtos.BranchDTO;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "branch")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    private String name;

    @ManyToOne
    private Account account;

    private String cnpj;

    public Branch() {
        super();
    }

    public Branch(BranchDTO obj){
        this.id = obj.getId();
        this.name = obj.getName();
        this.account = obj.getAccount();
        this.cnpj = obj.getCnpj();
    }

    

    public Branch(UUID id, String name, Account account, String cnpj) {
        this.id = id;
        this.name = name;
        this.account = account;
        this.cnpj = cnpj;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    

}
