package com.prova.domains;

import java.time.LocalDate;

import org.hibernate.validator.constraints.UUID;

import com.prova.domains.enums.TransactionType;

public class Transaction {

    private UUID id;
    private double amount;
    private LocalDate date;
    private TransactionType transactionType;

    public Transaction() {
    }

    public Transaction(UUID id, double amount, LocalDate date, TransactionType transactionType) {
        this.id = id;
        this.amount = amount;
        this.date = date;
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
