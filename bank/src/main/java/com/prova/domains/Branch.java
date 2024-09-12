package com.prova.domains;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "branch")
public class Branch {

    private Integer id;
    private String name;
    private Account accounts;
    @Column(unique = true)
    private String cnpj;

    public Branch() {
    }

    public Branch(Integer id, String name, Account accounts, String cnpj) {
        this.id = id;
        this.name = name;
        this.accounts = accounts;
        this.cnpj = cnpj;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccounts() {
        return accounts;
    }

    public void setAccounts(Account accounts) {
        this.accounts = accounts;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    

}
