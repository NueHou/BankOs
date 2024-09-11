package com.prova.domains;

import com.prova.domains.enums.AccountStatus;
import com.prova.domains.enums.AccountType;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(
   name = "Account"
)
public class Account {
   @Id
   private int id;
   private double balance;
   private AccountType accountType;
   private AccountStatus status;

   public Account() {
   }

   public Account(int id, double balance, AccountType accountType, AccountStatus status) {
      this.id = id;
      this.balance = balance;
      this.accountType = accountType;
      this.status = status;
   }

   public int getId() {
      return this.id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public double getBalance() {
      return this.balance;
   }

   public void setBalance(double balance) {
      this.balance = balance;
   }

   public AccountType getAccountType() {
      return this.accountType;
   }

   public void setAccountType(AccountType accountType) {
      this.accountType = accountType;
   }

   public AccountStatus getStatus() {
      return this.status;
   }

   public void setStatus(AccountStatus status) {
      this.status = status;
   }
}
