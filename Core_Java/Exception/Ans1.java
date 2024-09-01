package Exception;

import java.util.Scanner;

public class Ans1 
{
    public static void main(String[] args) 
    {
    	int numerator = 0;
    	int denominator = 0;
    	int result;
    	
		try 
		{
			result = numerator / denominator;
			System.out.println("Result: "+result);
		} 
		catch (Exception e) 
		{
		    System.out.println("Error: Cannot divide by zero.");
		}
	}
}
