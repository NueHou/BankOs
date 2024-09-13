package com.prova.dtos;

import java.sql.Date;
import java.util.UUID;

import com.prova.domains.Transaction;

public class TransactionDTO {
    private UUID id;
    private double amount;
    private Date date;
    private Transaction transaction;
    
    
    public TransactionDTO() {
    }

    public TransactionDTO(Transaction transaction) {
        
        
    }

    
}
