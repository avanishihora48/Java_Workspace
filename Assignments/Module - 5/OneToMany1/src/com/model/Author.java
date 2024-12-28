package com.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="author")
public class Author 
{
   @OneToMany
   private List<Books>books;

	public List<Books> getBooks() {
		return books;
	}
	
	public void setBooks(List<Books>books) {
		this.books = books;
	}
	   
	 @Id
	 @GenericGenerator(name = "increment", strategy = "increment")
	 @GeneratedValue(generator="increment")
	 @Column(name="aid")
	 private int id;
	 
	 @Column(name="name")
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
