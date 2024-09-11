package com.prova.domains;

public class Branch {

    private Integer id;
    private String name;
    private Account accounts;
    private String cnpj;
    private CnpjBranch cnpjBranch;

    public Branch() {
    }

    public Branch(Integer id, String name, Account accounts, String cnpj, CnpjBranch cnpjBranch) {
        this.id = id;
        this.name = name;
        this.accounts = accounts;
        this.cnpj = cnpj;
        this.cnpjBranch = cnpjBranch;
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
    public Account getAccounts() {
        return accounts;
    }
    public void setAccounts(Account accounts) {
        this.accounts = accounts;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public CnpjBranch getCnpjBranch() {
        return cnpjBranch;
    }
    public void setCnpjBranch(CnpjBranch cnpjBranch) {
        this.cnpjBranch = cnpjBranch;
    }

    
}
