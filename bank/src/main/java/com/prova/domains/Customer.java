package com.prova.domains;

import com.prova.domains.enums.PersonType;
import com.prova.domains.dtos.CustomerDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.stream.Collectors;


@Entity
@Table(name = "customer")
public class Customer extends Person{


    public Customer(Integer id, String password, String email, String cpf, String lastName, String firstName, Account account) {
        super(id, password, email, cpf, lastName, firstName, account);
        addPersonType(PersonType.CUSTOMER);
    }

    public Customer(CustomerDTO obj) {
        this.id = obj.getId();
        this.firstName = obj.getFirstName();
        this.lastName = obj.getLastName();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.password = obj.getPassword();
        this.personType = obj.getPersonType().stream().map(x -> x.getId()).collect(Collectors.toSet());
        addPersonType(PersonType.CUSTOMER);
    }


    public Customer(){
        super();
        addPersonType(PersonType.CUSTOMER);
    }

}
