package com.prova.domains.enums;

public enum AccountType {

    SAVINGS(0, "ROLE_SAVINGS"),CHEKING(1, "ROLE_CHEKING"),BUSINESS(2, "ROLE_BUSINESS");
 
    private Integer id;
    private String tipo;
 
    private AccountType(Integer id, String tipo) {
       this.id = id;
       this.tipo = tipo;
    }
 
    public Integer getId() {
       return this.id;
    }
 
    public void setId(Integer id) {
       this.id = id;
    }
 
    public String getTipo() {
       return this.tipo;
    }
 
    public void setTipo(String tipo) {
       this.tipo = tipo;
    }
 
    public static AccountType toEnum(Integer id) {
       if (id == null) {
          return null;
       } else {
          AccountType[] var4;
          int var3 = (var4 = values()).length;
 
          for(int var2 = 0; var2 < var3; ++var2) {
             AccountType x = var4[var2];
             if (id.equals(x.getId())) {
                return x;
             }
          }
 
          throw new IllegalArgumentException("AccountType invalida");
       }
    }
}


