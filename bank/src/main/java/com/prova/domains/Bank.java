package com.prova.domains;

import com.prova.domains.dtos.BankDTO;

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


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Bank other = (Bank) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
}
