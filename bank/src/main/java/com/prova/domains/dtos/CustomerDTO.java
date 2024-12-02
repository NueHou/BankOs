package com.prova.domains.dtos;

import com.prova.domains.Account;
import com.prova.domains.Customer;
import com.prova.domains.enums.PersonType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CustomerDTO {

    protected Integer id;

    @NotNull(message = "O campo nãio pode ser nulo!")
    @NotBlank(message = "O campo não pode ser Vazio!")
    protected String firstName;

    @NotNull(message = "O campo nãio pode ser nulo!")
    @NotBlank(message = "O campo não pode ser Vazio!")
    protected String lastName;

    @NotNull(message = "O campo nãio pode ser nulo!")
    @CPF
    protected String cpf;

    protected Account account;

    @NotNull(message = "O campo nãio pode ser nulo!")
    @NotBlank(message = "O campo não pode ser Vazio!")
    protected String email;

    @NotNull(message = "O campo nãio pode ser nulo!")
    @NotBlank(message = "O campo não pode ser Vazio!")
    protected String password;

    protected Set<Integer> personType = new HashSet<>();
    
    
    public CustomerDTO() {
    }



    public CustomerDTO(Customer obj) {
        this.id = obj.getId();
        this.firstName = obj.getFirstName();
        this.lastName = obj.getLastName();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.password = obj.getPassword();
        this.account = obj.getAccount();
        this.personType = obj.getPersonType().stream().map(x -> x.getId()).collect(Collectors.toSet());
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Set<PersonType> getPersonType() {
        return personType.stream().map(x -> PersonType.toEnum(x)).collect(Collectors.toSet());
    }

    public void addPersonType(PersonType personType) {
        this.personType.add(personType.getId());
    }
}
