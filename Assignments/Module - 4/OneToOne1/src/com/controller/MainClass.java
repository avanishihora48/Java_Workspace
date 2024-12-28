package com.controller;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.connect.Util;
import com.model.Profile;
import com.model.User;

public class MainClass 
{
   public static void main(String[] args) 
   {
	   Session sess = new Util().getconnect();
	   Transaction tr = sess.beginTransaction();
	   
	   Scanner sc = new Scanner(System.in);
	   
	   System.out.println("Enter your name: ");
	   String name = sc.next();
	   
	   System.out.println("Enter your email: ");
	   String email = sc.next();
	   
	   System.out.println("Enter your password: ");
	   String pass = sc.next();
	   
	   Profile p = new Profile();
	   p.setName(name);
	   p.setEmail(email);
	   p.setPass(pass);
	   
	   User u1 = new User();
	   u1.setName(name);
	   u1.setProfile(p);
	   
	    sess.save(p);
		sess.save(u1);
		tr.commit();
		sess.close();
   }
}
