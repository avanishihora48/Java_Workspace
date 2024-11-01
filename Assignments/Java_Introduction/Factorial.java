package Task;

import java.util.Scanner;

public class Factorial {
     public static void main(String[] args) {
		 Scanner fac = new Scanner(System.in);
		 
		 System.out.println("Enter the number you want to get factorial: ");
		 int num = fac.nextInt();
		 
		 int fact = 1;
		 for (int i=1 ;i<=num; i++) {
			 fact *= i;
		 }
		 System.out.println("Fctorial of given number is: "+fact);
	}
}
