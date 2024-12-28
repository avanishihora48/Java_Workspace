package controller;

import java.util.Scanner;

import dao.Dao;
import model.Employee;

public class Insert 
{
    public static void main(String[] args) 
    {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Name");
		String name = sc.next();
		
		System.out.println("Enter department");
		String department = sc.next();
		
		System.out.println("Enter salary");
		String salary = sc.next();
		
		Employee emp = new Employee();
		emp.setName(name);
		emp.setDepartment(department);
		emp.setSalary(salary);
		
		new Dao().insertdata(emp);
	}
}
