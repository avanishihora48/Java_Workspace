package com.model;

import java.sql.Timestamp;

public class TelephoneModel 
{
	 private String citizenId;
	 private String callType;
	 private Timestamp callStartTime; 
	 private long callDuration;       
	 private int callRate;
	 private double callCharges;
	 
	public String getCitizenId() {
		return citizenId;
	}
	public void setCitizenId(String citizenId) {
		this.citizenId = citizenId;
	}
	public String getCallType() {
		return callType;
	}
	public void setCallType(String callType) {
		this.callType = callType;
	}
	public Timestamp getCallStartTime() {
		return callStartTime;
	}
	public void setCallStartTime(Timestamp callStartTime) {
		this.callStartTime = callStartTime;
	}
	public long getCallDuration() {
		return callDuration;
	}
	public void setCallDuration(long callDuration) {
		this.callDuration = callDuration;
	}
	public int getCallRate() {
		return callRate;
	}
	public void setCallRate(int callRate) {
		this.callRate = callRate;
	}
	public double getCallCharges() {
		return callCharges;
	}
	public void setCallCharges(double callCharges) {
		this.callCharges = callCharges;
	}
	
}
