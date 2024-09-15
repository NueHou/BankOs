package com.prova.repositories;

import java.util.Optional; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prova.domains.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Integer>{

    Optional<Bank> findByCnpj(String cnpj);

}
