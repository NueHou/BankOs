package com.prova.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prova.dtos.BranchDTO;
import com.prova.repositories.BranchRepository;

@Service
public class BranchService {

    @Autowired
    private BranchRepository branchRepo;

    public List<BranchDTO> findAll(){
        return branchRepo.findAll().stream().map(obj -> new BranchDTO()).collect(Collectors.toList());
    }
}
