package com.prova.dtos;

import com.prova.domains.Account;
import com.prova.domains.Customer;

public class CustomerDTO {
    
    protected Integer id;
    protected String name;
    protected String address;
    protected Account account;
    protected String cpf;
    
    
    public CustomerDTO() {
    }
    

    public CustomerDTO(Customer obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.address = obj.getAddress();
        this.account = obj.getAccount();
        this.cpf = obj.getCpf();

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


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public Account getAccount() {
        return account;
    }


    public void setAccount(Account account) {
        this.account = account;
    }


    public String getCpf() {
        return cpf;
    }


    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    
}
