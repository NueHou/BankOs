package com.prova.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prova.domains.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, UUID>{

}
