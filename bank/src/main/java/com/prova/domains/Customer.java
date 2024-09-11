package com.prova.domains;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity

@Table(
    name = "Customer"
)
public class Customer {
    
    
    @Id
    private int id;
    private String name;
    private String address;
    private Account account;
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
