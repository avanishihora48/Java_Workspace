package OOP;

import java.util.Scanner;

public class Ans3
{
	static String name;
	static String add;
	static int phno;
	static int age;
	static int sal;
	
    Ans3(String name,String add,int phno,int age,int sal)
    {
    	 this.name = name;
    	 this.add = add;
    	 this.phno = phno;
    	 this.age = age;
    	 this.sal = sal;
    }
     
    public void printSalary() {
        System.out.print("Salary: " + sal);
    }
    
     public static void main(String[] args) 
    {
		Scanner s = new Scanner(System.in);
		
		System.out.print("Enter Your Name: ");
		name = s.next();
		
		System.out.print("Enter Your Age: ");
		age = s.nextInt();
		
		System.out.print("Enter Your phone number: ");
		phno = s.nextInt();
		
		System.out.print("Enter Your Address: ");
		add = s.next();
		
		System.out.print("Enter Your Salary: ");
		sal = s.nextInt();
		
		 Ans3 member = new Ans3(name, add, phno, age, sal);
	     member.printSalary();
		
	}
}
