package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import connect.Util;
import dao.Dao;
import model.Department;
import model.Employee;

public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 1;

        Session sess = new Util().getconnect();

        do {
            Transaction tr = sess.beginTransaction(); 
            try {
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
                        Employee emp1 = new Employee();
                        Employee emp2 = new Employee();
                        Department dept = new Department();

                        System.out.println("Enter Employee 1 name: ");
                        emp1.setName(scanner.nextLine());

                        System.out.println("Enter Employee 2 name: ");
                        emp2.setName(scanner.nextLine());

                        System.out.println("Enter department name: ");
                        dept.setName(scanner.nextLine());

                        emp1.setDepart(dept);
                        emp2.setDepart(dept);

                        List<Employee> list = new ArrayList<>();
                        list.add(emp1);
                        list.add(emp2);
                        dept.setEmps(list);

                        new Dao().insertEmployee(emp1, dept);
                        new Dao().insertEmployee(emp2, dept);

                        tr.commit();  

                        System.out.println("Employees inserted successfully!");
                        break;

                    case 2: 
                        List<Employee> employeeList = new Dao().getAllEmployees();
                        System.out.println("ID\t|\tName\t|\tDepartment");

                        for (Employee person : employeeList) {
                            System.out.println(person.getId() + "\t|\t" + person.getName() + "\t|\t" + person.getDepart().getName());
                        }
                        break;

                    case 3: 
                        System.out.print("Enter employee ID to update: ");
                        int empIdForUpdate = scanner.nextInt();
                        scanner.nextLine();  

                        System.out.print("Enter new department: ");
                        String newDepartment = scanner.nextLine();

                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();

                        new Dao().updateEmployeeDetails(empIdForUpdate, newName, newDepartment);

                        tr.commit();  // Commit the transaction

                        System.out.println("Employee details updated successfully!");
                        break;

                    case 4: 
                    	System.out.print("Enter employee ID to delete: ");
                    	int empIdForDelete = scanner.nextInt();

                    	new Dao().deleteEmployee(empIdForDelete);

                    	System.out.println("Employee deleted successfully!");
                    	break;

                    case 5:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            } catch (Exception e) {
                tr.rollback();  
                System.out.println("Error occurred, transaction rolled back: " + e.getMessage());
            }
        } while (choice != 5);

        scanner.close();  
        sess.close();    
    }
}
