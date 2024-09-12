package com.prova.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prova.domains.Branch;

public interface BranchRepository extends JpaRepository<Branch, Integer>{

}
