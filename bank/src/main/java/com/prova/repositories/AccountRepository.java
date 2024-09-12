package com.prova.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prova.domains.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{

}
