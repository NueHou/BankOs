package com.prova.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prova.domains.Customer;
import com.prova.domains.enums.AccountStatus;
import com.prova.dtos.CustomerDTO;
import com.prova.repositories.CustomerRepository;
import com.prova.services.exceptions.DataIntegrityViolationException;
import com.prova.services.exceptions.ObjectNotFoundException;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepo;

    public List<CustomerDTO> findAll(){
        return customerRepo.findAll().stream().map(obj -> new CustomerDTO()).collect(Collectors.toList());
    }

    public Customer findById(int id){
        Optional<Customer> obj = customerRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não Encontrado! Id:"+id));
    }

    public Customer create(int id, CustomerDTO objDTO){
        objDTO.setId(id);
        ValidarPorCpf(objDTO);
        Customer newObj = new Customer(objDTO);
        return customerRepo.save(newObj);
    }

    public Customer update(int id, CustomerDTO objDto){
        objDto.setId(id);
        Customer oldObj = findById(id);
        ValidarPorCpf(objDto);
        oldObj = new Customer(objDto);
        return customerRepo.save(oldObj);
    }

    public void delete(int id){
        Customer obj = findById(id);
        obj.getAccount().getStatus();
        if (obj.getAccount().getStatus() == AccountStatus.ACTIVE) {
            throw new DataIntegrityViolationException("Cliente não pode ser deletado pois tem conta aberta!"); 
        }
        customerRepo.deleteById(id);
    }

    public void ValidarPorCpf(CustomerDTO objDto){
        Optional<Customer> obj = customerRepo.findByCpf(objDto.getCpf());
        if (obj.isPresent() && obj.get().getId() != objDto.getId()) {
            throw new DataIntegrityViolationException("CPF já cadastrado no Sistema!");
        }
    }
   
    
}
