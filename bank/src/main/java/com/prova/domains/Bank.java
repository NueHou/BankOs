package com.prova.domains;

import com.prova.dtos.BankDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bank")
public class Bank {

    @Id
    private Integer id;
    private String name;
    @ManyToOne
    private Customer customers;
    @Column(unique = true)
    private String cnpj;
    @ManyToOne
    private Branch cnpjBranch;

    public Bank() {
    }

    public Bank(BankDTO obj){
        this.id = obj.getId();
        this.name = obj.getName();
        this.customers = obj.getCustomers();
        this.cnpj = obj.getCnpj();
        this.cnpjBranch = obj.getCnpjBranch();
    }

    public Bank(Integer id, String name, Customer customers, String cnpj, Branch cnpjBranch) {
        this.id = id;
        this.name = name;
        this.customers = customers;
        this.cnpj = cnpj;
        this.cnpjBranch = cnpjBranch;
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
    public Customer getCustomers() {
        return customers;
    }
    public void setCustomers(Customer customers) {
        this.customers = customers;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public Branch getCnpjBranch() {
        return cnpjBranch;
    }
    public void setCnpjBranch(Branch cnpjBranch) {
        this.cnpjBranch = cnpjBranch;
    }

    
}
