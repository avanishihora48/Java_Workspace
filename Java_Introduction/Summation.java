package Task;

import java.util.Scanner;

public class Summation {
     public static void main(String[] args) {
		Scanner sum = new Scanner(System.in);
		
		int summ = 0;
		System.out.println("Enter the number you want summation: ");
		int num = sum.nextInt();
		
		while(num>0) {
			int rem = num % 10;
			summ += rem;
			num /= 10;
			
		}
		
		System.out.println("Summation of given number is: "+summ);
	}
}
