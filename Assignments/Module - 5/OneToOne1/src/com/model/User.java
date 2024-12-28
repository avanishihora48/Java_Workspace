package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="user")
public class User 
{
	@OneToOne
	private Profile profile;
	
   @Id
   @GenericGenerator(name = "increment", strategy = "increment")
   @GeneratedValue(generator="increment")
   @Column(name="uid")
   private int uid;
   
   @Column(name="name")
   private String name;

public Profile getProfile() {
	return profile;
}

public void setProfile(Profile profile) {
	this.profile = profile;
}

public int getId() {
	return uid;
}

public void setId(int id) {
	this.uid = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
   
   
}
