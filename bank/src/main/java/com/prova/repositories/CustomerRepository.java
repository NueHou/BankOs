package com.prova.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prova.domains.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
