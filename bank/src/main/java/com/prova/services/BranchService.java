package com.prova.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.prova.domains.Branch;
import com.prova.domains.enums.AccountStatus;
import com.prova.dtos.BranchDTO;
import com.prova.repositories.BranchRepository;
import com.prova.services.exceptions.DataIntegrityViolationException;
import com.prova.services.exceptions.ObjectNotFoundException;

@Service
public class BranchService {

    @Autowired
    private BranchRepository branchRepo;

    public List<BranchDTO> findAll(){
        return branchRepo.findAll().stream().map(obj -> new BranchDTO()).collect(Collectors.toList());
    }

    public Branch findById(Integer id){
        Optional<Branch> obj = branchRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não Encontrado! Id:"+id));
    }

    public Branch findByCnpj(String cnpj){
        Optional<Branch> obj = branchRepo.findByCnpj(cnpj);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Cnpj  não Encontrado! Cnpj:"+cnpj));
    }

    public Branch create(Integer id, BranchDTO objDTO){
        objDTO.setId(id);
        ValidarPorCnpj(objDTO);
        Branch newObj = new Branch(objDTO);
        return branchRepo.save(newObj);
    }

    public Branch update(Integer id, BranchDTO objDto){
        objDto.setId(id);
        Branch oldObj = findById(id);
        ValidarPorCnpj(objDto);
        oldObj = new Branch(objDto);
        return branchRepo.save(oldObj);
    }

    public void delete(Integer id){
        Branch obj = findById(id);
        obj.getCnpj();
        if (obj.getAccount().getStatus() == AccountStatus.ACTIVE) {
            throw new DataIntegrityViolationException("Agencia não pode ser deletado pois tem conta aberta!"); 
        }
        branchRepo.deleteById(id);
    }

    public void ValidarPorCnpj(BranchDTO objDto){
        Optional<Branch> obj = branchRepo.findByCnpj(objDto.getCnpj());
        if (obj.isPresent() && obj.get().getId() != objDto.getId()) {
            throw new DataIntegrityViolationException("CNPJ já cadastrado no Sistema!");
        }
    }
}
