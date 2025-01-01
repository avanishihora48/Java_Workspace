package com.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass 
{
    public static void main(String[] args) 
    {
		ApplicationContext acm = new ClassPathXmlApplicationContext("beans.xml");
		Person p = (Person) acm.getBean("p1");
		System.out.println("Hello: "+p.getName());
	}
}
