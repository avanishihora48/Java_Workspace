package controller;

import java.util.Scanner;

import dao.Dao;
import model.Employee;

public class Update 
{
   public static void main(String[] args) 
   {
	   Scanner sc = new Scanner(System.in);
	   
	   System.out.println("Enter ID");
	   int id = sc.nextInt();
		
	   System.out.println("Enter name: ");
	   String name = sc.next();
	   
	   System.out.println("Enter department: ");
	   String department = sc.next();
	   
	   System.out.println("Enter Salary: ");
	   String salary = sc.next();
	   
	   Employee emp = new Employee();
	   emp.setId(id);
	   emp.setName(name);
	   emp.setDepartment(department);
	   emp.setSalary(salary);
	   
	   new Dao().updatedata(emp);
   }
}
