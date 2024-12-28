package controller;

import java.util.Scanner;

import dao.Dao;
import model.Employee;

public class Delete 
{
    public static void main(String[] args) 
    {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter id: ");
		int id = sc.nextInt();
		
		Employee emp = new Employee();
		emp.setId(id);
		
		new Dao().deletedata(emp);
	}
}
