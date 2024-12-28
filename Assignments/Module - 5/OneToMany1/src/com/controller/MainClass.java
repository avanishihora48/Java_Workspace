package com.controller;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.connect.Util;
import com.model.Author;
import com.model.Books;

public class MainClass 
{
    public static void main(String[] args) 
    {
		Session sess = new Util().getconnect();
		Transaction tr = sess.beginTransaction();
		
		Books b = new Books();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Book name: ");
		b.setTitle(sc.next());
		
		Books b1 = new Books();
		System.out.println("Enter Book2 name: ");
		b1.setTitle(sc.next());
		
		Author a = new Author();
		System.err.println("Enter Authors name: ");
		a.setName(sc.next());
		b.setAuthor(a);
		b1.setAuthor(a);
		
		List<Books>list = new ArrayList<>();
		list.add(b);
		list.add(b1);
		
		
		sess.save(b);
		sess.save(b1);
		sess.save(a);
		tr.commit();
		sess.close();
		
	}
}
