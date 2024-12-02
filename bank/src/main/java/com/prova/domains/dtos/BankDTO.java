package com.prova.domains.dtos;

import com.prova.domains.Bank;
import com.prova.domains.Branch;
import com.prova.domains.Customer;


public class BankDTO {

    private Integer id;
    private String name;
    private Customer customers;
    private String cnpj;
    
    private Branch cnpjBranch;
   

    public BankDTO() {
    }
    
    public BankDTO(Bank obj){
        this.id = obj.getId();
        this.name = obj.getName();
        this.customers = obj.getCustomers();
        this.cnpj = obj.getCnpj();
        this.cnpjBranch = obj.getCnpjBranch();
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

    public void setCustomers(Customer customer) {
        this.customers = customer;
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
