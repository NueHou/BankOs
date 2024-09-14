package com.prova.domains;


import com.prova.domains.enums.AccountStatus;
import com.prova.domains.enums.AccountType;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "account")
public class Account {

   private int id;
   private double balance;
   private AccountType tipo;
   private AccountStatus status;

   public Account() {
   }

   public Account(int id, double balance, AccountType tipo, AccountStatus status) {
      this.id = id;
      this.balance = balance;
      this.tipo = tipo;
      this.status = status;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public double getBalance() {
      return balance;
   }

   public void setBalance(double balance) {
      this.balance = balance;
   }

   public AccountType getTipo() {
      return tipo;
   }

   public void setTipo(AccountType tipo) {
      this.tipo = tipo;
   }

   public AccountStatus getStatus() {
      return status;
   }

   public void setStatus(AccountStatus status) {
      this.status = status;
   }

   
   
}
