package controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

import connect.Util;
import dao.Dao;
import model.Employee;
import model.Profile;

public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            
            System.out.println("Employee Management System");
            System.out.println("1. Insert a new employee");
            System.out.println("2. View all employees");
            System.out.println("3. Update employee details");
            System.out.println("4. Delete an employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    
                    Profile pro = new Profile();
                   
                    System.out.print("Enter the employee's address: ");
                    String address = scanner.nextLine(); 
                    pro.setAddress(address);

                    Employee emp = new Employee();

                    System.out.print("Enter the employee's name: ");
                    String name = scanner.nextLine();
                    emp.setName(name);

                    System.out.print("Enter the employee's department: ");
                    String department = scanner.nextLine();
                    emp.setDepartment(department);

                    System.out.print("Enter the employee's salary: ");
                    double salary = scanner.nextDouble();
                    emp.setSalary(salary);

                    pro.setEmployee(emp);
                    
                    new Dao().insertEmployee(emp, pro);
                    System.out.println("Employee inserted successfully!");
                    break;

                case 2:
                   
                	List<Employee>list = new Dao().getAllEmployees();
            		
            		System.out.println("ID\t|\tName\t");
            		
            		for (Employee person : list) 
            		{
            			//i++;
            			System.out.println(person.getId()+"\t|\t"+person.getName());
            			
            		}
            		
                    break;

                case 3:
                    
                    System.out.print("Enter employee ID : ");
                    int empIdForUpdate = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter new department: ");
                    String newDepartment = scanner.nextLine();

                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();

                    
                    System.out.print("Enter new salary: ");
                    double newSalary = scanner.nextDouble();

                    new Dao().updateEmployeeDetails(empIdForUpdate,newName, newDepartment, newSalary);
                    System.out.println("Employee details updated successfully!");
                    break;

                case 4:  
                    System.out.print("Enter employee ID: ");
                    int emp1 = scanner.nextInt();
                    new Dao().deleteEmployee(emp1);
                    System.out.println("Employee deleted successfully!");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 5); 

        
    }
}
