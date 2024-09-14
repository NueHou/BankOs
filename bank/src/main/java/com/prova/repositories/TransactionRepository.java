package com.prova.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prova.domains.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, UUID>{
    

}
