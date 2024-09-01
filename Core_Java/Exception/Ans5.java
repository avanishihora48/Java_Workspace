package Exception;

import java.lang.classfile.constantpool.Utf8Entry;

public class Ans5 
{
    public static void main(String[] args) 
    {
		if(args.length != 2)
		{
			System.out.println("Please provide exactly two numbers as arguments.");
		}
		
		try 
		{
			int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);
            
            int result = num1 / num2;
            
            System.out.println("Result: " + result);
		} 
		catch (ArithmeticException e) 
		{
			System.out.println("Error: Division by zero is not allowed.");
		}
		catch (NumberFormatException e) 
		{
			System.out.println("Error: Please provide valid integers.");
	    }
     }
}