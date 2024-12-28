package com.connect;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.model.Author;
import com.model.Books;


public class Util 
{
    public Session getconnect()
    {
    	Session sess = null;
    	Properties properties = new Properties();
    	
    	properties.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
 	    properties.setProperty("hibernate.connection.password", "");
 		properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/library");
 		properties.setProperty("hibernate.connection.username", "root");
 		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
 		properties.setProperty("hibernate.show_sql", "true");
 		properties.setProperty("hibernate.format_sql", "true");
 		properties.setProperty("hibernate.hbm2ddl.auto", "update");
 		SessionFactory sf  = new Configuration()
				.addAnnotatedClass(Author.class)
				.addAnnotatedClass(Books.class)
				.addProperties(properties)
				.buildSessionFactory();
		
		sess = sf.openSession();
		return sess;
    	
    }
}