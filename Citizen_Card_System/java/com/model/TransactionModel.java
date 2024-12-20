package com.model;

import java.security.Timestamp;

public class TransactionModel 
{
	    private int transactionId;
	    private String citizenId;
	    private String bank;
	    private String transactionType;
	    private double amount;
	    private Timestamp transactionDate;
	    
		public int getTransactionId() {
			return transactionId;
		}
		public void setTransactionId(int transactionId) {
			this.transactionId = transactionId;
		}
		public String getCitizenId() {
			return citizenId;
		}
		public void setCitizenId(String citizenId) {
			this.citizenId = citizenId;
		}
		public String getBank() {
			return bank;
		}
		public void setBank(String bank) {
			this.bank = bank;
		}
		public String getTransactionType() {
			return transactionType;
		}
		public void setTransactionType(String transactionType) {
			this.transactionType = transactionType;
		}
		public double getAmount() {
			return amount;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
		public Timestamp getTransactionDate() {
			return transactionDate;
		}
		public void setTransactionDate(Timestamp transactionDate) {
			this.transactionDate = transactionDate;
		}
    
   
}
