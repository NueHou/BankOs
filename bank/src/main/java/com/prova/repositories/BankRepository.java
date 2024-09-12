package com.prova.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prova.domains.Bank;

public interface BankRepository extends JpaRepository<Bank, Integer>{

}
