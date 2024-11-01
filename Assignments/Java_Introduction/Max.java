package Task;

import java.util.Scanner;

public class Max {
   public static void main(String[] args) {
	  
	   Scanner big = new Scanner(System.in);
	   
	   System.out.println("Enter the number: ");
	   int num = big.nextInt();
	   
	   int max = 0;
	   
	   while(num > 0) 
	   {
		   int rem = num%10;
		   
		   if(rem>max)
			{
				max = rem;
			}
			num /= 10;
		}
		   
	   System.out.println("Max Num is: "+max);
		
	}
}

