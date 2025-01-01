package com.model;

import org.springframework.stereotype.Component;

@Component("address")
public class Address 
{
	 private String city = "Los Angeles";
	 private String country = "USA";
	 
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		
		@Override
	    public String toString() {
	        return "Address{city='" + city + "', country='" + country + "'}";
	    }
}
