package com.prova.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prova.domains.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Integer>{

}
