package Exception;

import java.util.Scanner;

public class Ans6 
{
    public static void main(String[] args) 
    {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your age: ");
		int age = sc.nextInt();
		
		
			if(age >= 18)
			{
				System.out.println("You are eligible for vote..");
			}
			else 
		   {
			    throw new ArithmeticException("Age is not valid");
		   }
	  }
  }
