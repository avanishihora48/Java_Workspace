package com.school;

import java.util.ArrayList;
import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class MainClass 
{
    public static void main(String[] args) 
    {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        Transaction t = session.beginTransaction();

        Student student1 = new Student();
        student1.setName("Avani");

        Student student2 = new Student();
        student2.setName("Dhwani");
        
        Course course1 = new Course();
        course1.setName("Java");
        
        Course course2 = new Course();
        course2.setName("Python");
        
        ArrayList<Course> courses = new ArrayList<>(Arrays.asList(course1, course2));
        ArrayList<Student> students = new ArrayList<>(Arrays.asList(student1, student2));

        course1.setStudents(students); 
        course2.setStudents(students); 
     
        session.persist(course1);
        session.persist(course2);

        t.commit();
        session.close();
        factory.close();

        System.out.println("Data saved successfully!");
    }
}
