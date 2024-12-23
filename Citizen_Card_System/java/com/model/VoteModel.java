package com.model;

import java.sql.Timestamp;

public class VoteModel 
{
	  private String citizenId; 
	  private String area;
	  private String candidate;
	  private Timestamp votingDate;
	  
		public String getCitizenId() {
			return citizenId;
		}
		public void setCitizenId(String citizenId) {
			this.citizenId = citizenId;
		}
		public String getArea() {
			return area;
		}
		public void setArea(String area) {
			this.area = area;
		}
		public String getCandidate() {
			return candidate;
		}
		public void setCandidate(String candidate) {
			this.candidate = candidate;
		}
		public Timestamp getVotingDate() {
			return votingDate;
		}
		public void setVotingDate(Timestamp transactionDate) {
			this.votingDate = transactionDate;
		}
}
