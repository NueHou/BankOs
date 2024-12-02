package com.prova.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.prova.domains.Customer;
import com.prova.domains.enums.AccountStatus;
import com.prova.domains.dtos.CustomerDTO;
import com.prova.repositories.CustomerRepository;
import com.prova.services.exceptions.DataIntegrityViolationException;
import com.prova.services.exceptions.ObjectNotFoundException;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public List<CustomerDTO> findAll(){
        return customerRepo.findAll().stream().map(obj -> new CustomerDTO(obj)).collect(Collectors.toList());
    }

    public Customer findById(Integer id){
        Optional<Customer> obj = customerRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não Encontrado! Id:"+id));
    }

    public Customer findByCpf(String cpf){
        Optional<Customer> obj = customerRepo.findByCpf(cpf);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Cpf não encontrado! Cpf:"+cpf));
    }

    public Customer findByEmail(String email){
        Optional<Customer> obj = customerRepo.findByEmail(email);
        return obj.orElseThrow(() -> new ObjectNotFoundException("EMAIL não encontrado! email:"+email));
    }

    public Customer create(Integer id, CustomerDTO objDTO){
        objDTO.setId(id);
        objDTO.setPassword(encoder.encode(objDTO.getPassword()));
        ValidarPorCpf(objDTO);
        Customer newObj = new Customer(objDTO);
        return customerRepo.save(newObj);
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
