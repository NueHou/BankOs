package com.prova.domains.dtos;




import com.prova.domains.Account;
import com.prova.domains.Branch;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BranchDTO {

    
    protected Integer id;

    @NotNull(message = "O campo nome não pode ser nulo")
    @NotBlank(message = "O campo nome não pode ser vazio")
    protected String name;

    @NotNull(message = "O campo nome não pode ser nulo")
    @NotBlank(message = "O campo nome não pode ser vazio")
    protected Account account;

    @NotNull(message = "O campo nome não pode ser nulo")
    @NotBlank(message = "O campo nome não pode ser vazio")
    protected String cnpj;
    
    
    public BranchDTO() {
    }

    public BranchDTO(Branch obj){
        this.id = obj.getId();
        this.name = obj.getName();
        this.account = obj.getAccount();
        this.cnpj = obj.getCnpj();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Account getAccount() {
        return account;
    }


    public void setAccount(Account account) {
        this.account = account;
    }


    public String getCnpj() {
        return cnpj;
    }


    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    
    

    
}
