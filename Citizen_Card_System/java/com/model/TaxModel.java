package com.model;

public class TaxModel 
{
	private String citizenId; 
	private double taxPaid;   
	private double taxDue;   
	private String bank;
	
	
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getCitizenId() {
		return citizenId;
	}
	public void setCitizenId(String citizenId) {
		this.citizenId = citizenId;
	}
	public double getTaxPaid() {
		return taxPaid;
	}
	public void setTaxPaid(double taxPaid) {
		this.taxPaid = taxPaid;
	}
	public double getTaxDue() {
		return taxDue;
	}
	public void setTaxDue(double taxDue) {
		this.taxDue = taxDue;
	}

	public void updateTaxPayment(double paymentAmount) {
		// TODO Auto-generated method stub
		 this.taxPaid += paymentAmount;
	     this.taxDue -= paymentAmount;
	}
	
	
	
}
