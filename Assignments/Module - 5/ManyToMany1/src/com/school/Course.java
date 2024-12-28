package com.school;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name="courses")
public class Course 
{
   @Id
   @GenericGenerator(name = "increment", strategy = "increment")
   @GeneratedValue(generator="increment")
   @Column(name="cid")
   private int id;
   
   @Column(name="cname")
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
   
@ManyToMany(targetEntity=Student.class,cascade = { CascadeType.ALL })
    
    @JoinTable(name="student_course",joinColumns= {@JoinColumn(name="cid")},
    inverseJoinColumns= {@JoinColumn(name="sid")})
    
    List<Student>students;

	public List<Student> getStudents() {
		return students;
	}
	
	public void setStudents(List<Student> students) {
		this.students = students;
	}

	
}
