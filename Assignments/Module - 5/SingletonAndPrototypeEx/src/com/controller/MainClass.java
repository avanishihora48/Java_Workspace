package com.controller;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.model.MyBean;

public class MainClass 
{
   public static void main(String[] args) 
   {
	   BeanFactory bf = new XmlBeanFactory(new ClassPathResource("beans.xml"));
	   
	   MyBean singletonBean1 = (MyBean) bf.getBean("singletonBean");
	   MyBean singletonBean2 = (MyBean) bf.getBean("singletonBean");
	   
	   MyBean prototypeBean1 = (MyBean) bf.getBean("prototypeBean");
	   MyBean prototypeBean2 = (MyBean) bf.getBean("prototypeBean");
	   
	   System.out.println("Singleton Bean Instance: ");
	   System.out.println("singletonBean1: " + singletonBean1);
       System.out.println("singletonBean2: " + singletonBean2);
       System.out.println("Are singletonBean1 and singletonBean2 the same? " + (singletonBean1 == singletonBean2));
       
       System.out.println("Prototype Bean Instance: ");
	   System.out.println("prototypeBean1: " + prototypeBean1);
       System.out.println("prototypeBean2: " + prototypeBean2);
       System.out.println("Are singletonBean1 and singletonBean2 the same? " + (prototypeBean1 == prototypeBean2));
       
   }
}
