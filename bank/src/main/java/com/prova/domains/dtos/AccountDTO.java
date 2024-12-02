package com.prova.domains.dtos;


import com.prova.domains.Account;
import com.prova.domains.enums.AccountStatus;
import com.prova.domains.enums.AccountType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AccountDTO {
    
    
    protected Integer id;

    @NotNull(message = "O campo nome não pode ser nulo")
    @NotBlank(message = "O campo nome não pode ser vazio")
    protected double balance;

    protected AccountType tipo;
    protected AccountStatus status;
    
   
    public AccountDTO() {

    }
    
    public AccountDTO(Account obj) {
        this.id = obj.getId();
        this.balance = obj.getBalance();
        this.tipo = obj.getTipo();
        this.status = obj.getStatus();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public AccountType getTipo() {
        return tipo;
    }

    public void setTipo(AccountType tipo) {
        this.tipo = tipo;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    

    
}
