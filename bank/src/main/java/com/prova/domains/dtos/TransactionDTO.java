package com.prova.domains.dtos;

import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.prova.domains.Transaction;
import com.prova.domains.enums.TransactionType;


public class TransactionDTO {

    
    private UUID id;
    private double amount;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date = LocalDate.now();
    private TransactionType transactionType;
    
    
    public TransactionDTO() {
    }

    public TransactionDTO(Transaction obj) {
        this.id = obj.getId();
        this.amount = obj.getAmount();
        this.date = obj.getDate();
        this.transactionType = obj.getTransactionType();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
    
}
