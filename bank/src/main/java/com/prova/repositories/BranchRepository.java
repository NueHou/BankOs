package com.prova.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prova.domains.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer>{

}
