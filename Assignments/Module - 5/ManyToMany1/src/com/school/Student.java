package com.school;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="students")
public class Student 
{
	 @Id
	 @GenericGenerator(name = "increment", strategy = "increment")
	 @GeneratedValue(generator="increment")
	 @Column(name="sid")
	 private int id;
	   
	 @Column(name="sname")
	 private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	 
}
