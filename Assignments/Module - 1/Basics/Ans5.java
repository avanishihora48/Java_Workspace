package Module2;

import java.util.Scanner;

public class Ans5 {
    public static void main(String[] args) {
		int sum = 0;
		
		Scanner nu = new Scanner(System.in);
		
		System.out.println("Enter any 5 number: ");
		
		for(int i=0; i<5 ;i++) {
			
			System.out.print("Number "+i+" :");
			int num = nu.nextInt();
			
			sum+=num;
	     }
		
	    double avg = (double)sum/5 ;
		System.out.println("The sum is: "+sum);
		System.out.println("Average is: "+avg);
		
	}
}
