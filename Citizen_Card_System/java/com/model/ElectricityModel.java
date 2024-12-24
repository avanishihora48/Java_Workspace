package com.model;

public class ElectricityModel 
{
	private String citizenId;
	private int previousUnits;  
	private int currentUnits;   
	private double ratePerUnit; 
	private double totalCharges;
	
	public String getCitizenId() {
		return citizenId;
	}
	public void setCitizenId(String citizenId) {
		this.citizenId = citizenId;
	}
	public int getPreviousUnits() {
		return previousUnits;
	}
	public void setPreviousUnits(int previousUnits) {
		this.previousUnits = previousUnits;
	}
	public int getCurrentUnits() {
		return currentUnits;
	}
	public void setCurrentUnits(int currentUnits) {
		this.currentUnits = currentUnits;
	}
	public double getRatePerUnit() {
		return ratePerUnit;
	}
	public void setRatePerUnit(double ratePerUnit) {
		this.ratePerUnit = ratePerUnit;
	}
	public double getTotalCharges() {
		return totalCharges;
	}
	public void setTotalCharges(double totalCharges) {
		this.totalCharges = totalCharges;
	} 
    
	
}
