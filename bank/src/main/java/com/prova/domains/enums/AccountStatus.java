package com.prova.domains.enums;

public enum AccountStatus {
    ACTIVE(0, "ROLE_ACTIVE"),CLOSED(1, "ROLE_CLOSED"),SUSPENDED(2, "ROLE_SUSPENDED");
 
    private Integer id;
    private String status;
 
    private AccountStatus(Integer id, String status) {
       this.id = id;
       this.status = status;
    }
 
    public Integer getId() {
       return this.id;
    }
 
    public void setId(Integer id) {
       this.id = id;
    }
 
    public String getStatus() {
       return this.status;
    }
 
    public void setStatus(String status) {
       this.status = status;
    }
 
    public static AccountStatus toEnum(Integer id) {
       if (id == null) {
          return null;
       } else {
          AccountStatus[] var4;
          int var3 = (var4 = values()).length;
 
          for(int var2 = 0; var2 < var3; ++var2) {
             AccountStatus x = var4[var2];
             if (id.equals(x.getId())) {
                return x;
             }
          }
 
          throw new IllegalArgumentException("AccountStatus invalida");
       }
    }

}
