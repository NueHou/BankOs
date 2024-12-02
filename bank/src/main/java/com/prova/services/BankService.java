package com.prova.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prova.domains.Bank;
import com.prova.domains.enums.AccountStatus;
import com.prova.domains.dtos.BankDTO;
import com.prova.repositories.BankRepository;
import com.prova.services.exceptions.DataIntegrityViolationException;
import com.prova.services.exceptions.ObjectNotFoundException;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepo;

    public List<BankDTO> findAll(){
        return bankRepo.findAll().stream().map(obj -> new BankDTO(obj)).collect(Collectors.toList());
    }

    public Bank findById(Integer id){
        Optional<Bank> obj = bankRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não Encontrado! Id:"+id));
    }

    public Bank findByCnpj(String cnpj){
        Optional<Bank> obj = bankRepo.findByCnpj(cnpj);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Banco não encontrado! Cnpj:"+cnpj));
    }

    public Bank create(Integer id, BankDTO objDTO){
        objDTO.setId(id);
        ValidarPorCnpj(objDTO);
        Bank newObj = new Bank(objDTO);
        return bankRepo.save(newObj);
    }

   

    public void delete(Integer id){
        Bank obj = findById(id);
        obj.getCnpj();
        if (obj.getCustomers().getAccount().getStatus() == AccountStatus.ACTIVE) {
            throw new DataIntegrityViolationException("Banco não pode ser deletado pois existem clientes com contas abertas!"); 
        }
        bankRepo.deleteById(id);
    }

    public void ValidarPorCnpj(BankDTO objDto){
        Optional<Bank> obj = bankRepo.findByCnpj(objDto.getCnpj());
        if (obj.isPresent() && obj.get().getId() != objDto.getId()) {
            throw new DataIntegrityViolationException("CNPJ já cadastrado no Sistema!");
        }
    }
    

}
