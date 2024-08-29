package OOP;

import java.util.Scanner;

public class Ans10 
{
    public static long Factorial(int n)
    {
    	long result = 1;
    	
    	for(int i=1; i<n; i++) 
    	{
    		result *= i;
    	}
		return result;	
    }
    
    public static void main(String[] args) 
    {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a non-negative number: ");
		int num = sc.nextInt();
		
		 if (num < 0) 
		 {
	        System.out.println("Factorial is not defined for negative numbers.");
	     } 
		 else 
		 {
	        long factorial = Factorial(num);
	        System.out.println(num + "! = " + factorial);
	     }
	}
}
