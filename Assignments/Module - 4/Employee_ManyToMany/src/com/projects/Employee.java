package com.projects;

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
@Table(name="employee3")
public class Employee 
{
	   @Id
	   @GenericGenerator(name = "increment", strategy = "increment")
	   @GeneratedValue(generator="increment")
	   @Column(name="employee_id")
	   int id;
	 
	   @Column(name="employee_name")
	    String ename;

		public int getId() {
			return id;
		}
	
		public void setId(int id) {
			this.id = id;
		}
	
		public String getEname() {
			return ename;
		}
	
		public void setEname(String ename) {
			this.ename = ename;
		}
	   
	   @ManyToMany(targetEntity=Project.class,cascade = { CascadeType.ALL })
	    
	    @JoinTable(name="employee3_project",joinColumns= {@JoinColumn(name="employee_id")},
	    inverseJoinColumns= {@JoinColumn(name="project_id")})
	    
	    List<Project>pro;

		public List<Project> getAnswers() {
			return pro;
		}

		public void setAnswers(List<Project> pro) {
			this.pro = pro;
		}

}
