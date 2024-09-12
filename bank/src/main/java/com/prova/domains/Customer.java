package com.prova.domains;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;



@Entity
@Table(name = "customer")
public class Customer {
    
    
    
    private int id;
    private String name;
    private String address;
    private Account account;
    @Column(unique = true)
    private String cpf;
   
    public Customer() {
    }

    public Customer(int id, String name, String address, Account account, String cpf) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.account = account;
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }




    public void setId(int id) {
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
