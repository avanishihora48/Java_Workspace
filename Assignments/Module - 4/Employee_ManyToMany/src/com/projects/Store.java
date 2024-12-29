package com.projects;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Store 
{
   public static void main(String[] args) {
	

	    StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
	    Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();  
	    SessionFactory factory=meta.getSessionFactoryBuilder().build();  
	    Session session=factory.openSession();  
	    Transaction t=session.beginTransaction();    
	  
	    Project pro1 = new Project();
	    pro1.setPname("Citizen card system");
	
	    Project pro2=new Project();
	    pro2.setPname("Doctor Finder");
		   
	    Employee emp1=new Employee();
	    emp1.setEname("Avani");
	
		ArrayList<Project> l1=new ArrayList<Project>();
		l1.add(pro1);
		l1.add(pro2);
		emp1.setAnswers(l1);
		
		Project pro3=new Project ();  
		pro3.setPname("E-commerce");  
		    
		      
		Project  pro4=new Project ();  
		pro4.setPname("Blog website");  
	   
		
		Employee emp2=new Employee();
		emp2.setEname("Dhwani");
		
		ArrayList<Project> l2=new ArrayList<Project>();
		l2.add(pro3);
		l2.add(pro4);
		emp2.setAnswers(l2);
		
		session.persist(emp1);  
	    session.persist(emp2);  
	      
	    t.commit();  
	    session.close();  
	    System.out.println("success");  
		
   }
}
