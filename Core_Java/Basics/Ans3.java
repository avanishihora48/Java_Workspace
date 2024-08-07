package Module2;

import java.util.Scanner;

public class Ans3 {
	public static void main(String[] args) {
		Scanner yr = new Scanner(System.in);
		
		System.out.println("Enter the year to find leap year or not: ");
		int year = yr.nextInt();
		
		if (year % 400 == 0) {
	        System.out.println("This year is leap year");
	    } else if (year % 100 == 0) {
	    	 System.out.println("This year is not leap year");
	    } else if (year % 4 == 0) {
	    	 System.out.println("This year is leap year");
	    } else {
	    	 System.out.println("This year is not leap year");
	    }
	 }
}
