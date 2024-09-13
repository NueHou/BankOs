package com.prova.dtos;



import com.prova.domains.Account;
import com.prova.domains.Branch;

public class BranchDTO {
    protected Integer id;
    protected String name;
    protected Account account;
    protected String cnpj;
    
    
    public BranchDTO() {
    }

    public BranchDTO(Branch obj){
        this.id = obj.getId();
        this.name = obj.getName();
        this.account = obj.getAccounts();
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
