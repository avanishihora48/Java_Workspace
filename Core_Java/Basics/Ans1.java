package Module2;

import java.util.Scanner;

public class Ans1 {
     public static void main(String[] args) {
    	 
    	 int max = 0;
    	Scanner nu = new Scanner(System.in);
		System.out.println("Enter any 3 number to find max: ");
		
		for(int i=0 ; i<3 ; i++) {
			
			System.out.print("Number "+i+": ");
			int num = nu.nextInt();
			
			   while(num > 0) 
			   {
				   int rem = num%10;
				   
				   if(rem>max)
					{
						max = rem;
					}
					num /= 10;
				}
	      }
		System.out.println("Maximum number is: "+max);
	}
}
