package controller;

import java.util.List;

import dao.Dao;
import model.Employee;

public class View 
{
   public static void main(String[] args) 
   {
	   List<Employee> list = new Dao().viewdata();
	   
	   System.out.println("ID\t|\tName\t|\tDepartment|\tSalary\t");
	   for(Employee employee : list)
	   {
		   System.out.println(employee.getId()+"\t|\t"+employee.getName()+"\t|\t"+employee.getDepartment()+"\t|\t"+employee.getSalary());
	   }
   }
}
