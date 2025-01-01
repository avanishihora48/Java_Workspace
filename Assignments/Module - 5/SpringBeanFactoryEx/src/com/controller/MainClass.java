package com.controller;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.model.Address;
import com.model.Person;

public class MainClass 
{
    public static void main(String[] args) 
    {
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("beans.xml"));
		 Person person = (Person) factory.getBean("person");
	     Address address = (Address) factory.getBean("address");
	        
	        System.out.println(person);
	        System.out.println(address);
	}
}
