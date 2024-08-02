package Task;

import java.util.Scanner;

public class Switch_case {
    public static void main(String[] args) {
		Scanner da = new Scanner(System.in);
		
		System.out.println("1. Monday");
		System.out.println("2. Tuesday");
		System.out.println("3. Wednesday");
		System.out.println("4. Thursday");
		System.out.println("5. Friday");
		System.out.println("6. Saturday");
		System.out.println("7. Sunday");
		
		System.out.println("Enter your choice: ");
		int day = da.nextInt();
		
		switch(day){
		   case 1:
		     System.out.println("Today is Monday.");
		     break;
		   case 2:
			     System.out.println("Today is Tuesday.");
			     break;
		   case 3:
			     System.out.println("Today is Wednesday.");
			     break;
		   case 4:
			     System.out.println("Today is Thursday.");
			     break;
		   case 5:
			     System.out.println("Today is Friday.");
			     break;
		   case 6:
			     System.out.println("Today is Saturday.");
			     break;  
		   case 7:
			     System.out.println("Today is Sunday.");
			     break;
			     
		   default : 
			   System.out.println("Invalid choice...");
			   break;
		}
	}
}
