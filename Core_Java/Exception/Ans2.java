package Exception;

import java.util.Scanner;

public class Ans2 
{
    public static void main(String[] args) 
    {
    	
    	int result;
    	
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter number 1: ");
    	int num1 = sc.nextInt();
    	
    	System.out.println("Enter number 2: ");
    	int num2 = sc.nextInt();
    	
    	try 
		{
			result = num1 / num2;
			System.out.println("Result: " + result);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		    System.out.println("Exception in thread main" + e);
		}
	}
}
