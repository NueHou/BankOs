package com.prova.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prova.domains.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{

}
