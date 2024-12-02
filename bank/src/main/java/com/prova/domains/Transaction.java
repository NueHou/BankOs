package com.prova.domains;

import java.time.LocalDate;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.prova.domains.enums.TransactionType;
import com.prova.domains.dtos.TransactionDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private double amount;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date = LocalDate.now();
    private TransactionType transactionType;

    public Transaction() {
        super();
    }

    public Transaction(TransactionDTO obj) {
        this.id = obj.getId();
        this.amount = obj.getAmount();
        this.date = obj.getDate();
        this.transactionType = obj.getTransactionType();
    }

    public Transaction(UUID id, double amount, TransactionType transactionType) {
        this.id = id;
        this.amount = amount;
        this.transactionType = transactionType;
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
        Transaction other = (Transaction) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    

    
    
}
