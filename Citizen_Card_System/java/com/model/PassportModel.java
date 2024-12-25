package com.model;

import java.sql.Timestamp;

public class PassportModel 
{
     private String citizenId;
     private String fullName;
     private String passportNumber;
     private Timestamp dateIssue;
     private Timestamp validUntil;
     
     
	public String getCitizenId() {
		return citizenId;
	}
	public void setCitizenId(String citizenId) {
		this.citizenId = citizenId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public Timestamp getDateIssue() {
		return dateIssue;
	}
	public void setDateIssue(Timestamp dateIssue) {
		this.dateIssue = dateIssue;
	}
	public Timestamp getValidUntil() {
		return validUntil;
	}
	public void setValidUntil(Timestamp validDate) {
		this.validUntil = validDate;
	}
     
     
     
}
