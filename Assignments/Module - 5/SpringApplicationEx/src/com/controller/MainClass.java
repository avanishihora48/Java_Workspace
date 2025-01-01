package com.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.Address;
import com.model.Person;

public class MainClass 
{
    public static void main(String[] args)
    {
    	ApplicationContext acm = new ClassPathXmlApplicationContext("beans.xml");
    	Person person = (Person) acm.getBean("person");
	    Address address = (Address) acm.getBean("address");
	        
	     System.out.println(person);
	     System.out.println(address);
		
	}
}
