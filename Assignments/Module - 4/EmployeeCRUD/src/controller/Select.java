
package controller;

import java.util.Scanner;

import dao.Dao;
import model.Employee;


public class Select 
{
	public static void main(String[] args) 
	{
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter ID");
		int id = sc.nextInt();
		
	
		Employee emp = new Employee();
		emp.setId(id);

		Employee emp2 = new Dao().getSingle(emp); 
		
		System.out.println(emp2.getId()+" "+emp2.getName());
	}
}
