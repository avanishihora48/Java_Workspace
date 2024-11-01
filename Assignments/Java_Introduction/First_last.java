package Task;

import java.util.Scanner;

public class First_last {
    public static void main(String[] args) {
		Scanner num = new Scanner(System.in);
		
		System.out.println("Enter the num: ");
		int sum = num.nextInt();
		
		int first = sum;
		int last = sum % 10;
		
		while(first>=10) {
			first /= 10;
		}
		
		int add = first + last;
		System.out.println("Addition of first and last is: "+add);
	}
}
