package com.prova.domains.enums;

public enum TransactionType {

    DEPOSIT(0, "ROLE_DEPOSIT"), WITHDRAWAL(1, "ROLE_WITHDRAWAL");

        private Integer id;
        private String transactionType;
        
        private TransactionType(Integer id, String transactionType) {
            this.id = id;
            this.transactionType = transactionType;
        }
        public Integer getId() {
            return id;
        }
        public void setId(Integer id) {
            this.id = id;
        }
        public String getTransactionType() {
            return transactionType;
        }
        public void setTransactionType(String transactionType) {
            this.transactionType = transactionType;
        }

        

}
