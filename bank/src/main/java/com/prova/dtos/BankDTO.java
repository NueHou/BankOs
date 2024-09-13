package com.prova.dtos;

import com.prova.domains.Bank;
import com.prova.domains.Branch;
import com.prova.domains.Customer;

public class BankDTO {
    private Integer id;
    private String name;
    private Customer customer;
    private String cnpj;
    private Branch branch;
   

    public BankDTO() {
    }
    
    public BankDTO(Bank obj){
        this.id = obj.getId();
        this.name = obj.getName();
        this.customer = obj.getCustomers();
        this.cnpj = obj.getCnpj();
        this.branch = obj.getCnpjBranch();

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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
    

}
