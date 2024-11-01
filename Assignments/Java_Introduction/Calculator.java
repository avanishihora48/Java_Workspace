package Task;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
		System.out.println("1. Addition");
		System.out.println("2. Substraction");
		System.out.println("3. Multiplication");
		System.out.println("4. Division");
	
		Scanner cal = new Scanner(System.in);
		
		System.out.println("Enter your choice: ");
		int ent = cal.nextInt();
		
		System.out.println("Enter the value of a: ");
		int a = cal.nextInt();
		
		System.out.println("Enter the value of b: ");
		int b = cal.nextInt();
		
		switch(ent){
		   case 1:
		     System.out.println("Addition is: "+(a+b));
		     break;
		   case 2:
			     System.out.println("Substraction is: "+(a-b));
			     break;
		   case 3:
			     System.out.println("Multiplication is:"+(a*b));
			     break;
		   case 4:
			     System.out.println("Divion is: "+(a/b));
			     break;
		   default:
			   System.out.println("Invalid choice...");
			   break;
	   }
    }
}