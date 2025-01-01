package com.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.Person;

public class MainClass 
{
	public static void main(String[] args) 
	{
		 ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

	     Person person = (Person) context.getBean("person");

	     System.out.println(person);
	}
	
}
