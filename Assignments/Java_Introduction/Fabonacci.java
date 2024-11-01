package Task;

import java.util.Scanner;

public class Fabonacci {
     public static void main(String[] args) {
		
    	 Scanner fab = new Scanner(System.in);
    	 
    	 int first = 0, second = 1;
    	 
    	 System.out.println("Enter the number of terms: ");
    	 int num = fab.nextInt();
    	 
    	 System.out.print("Fabonacci: "+first +" , "+second);
    	 
    	 
    	 for(int i = 3 ; i <= num ; i++) {
    		 
    		 int next = first + second;
    		 System.out.print(" , "+ next);
    		 first = second;
    		 second = next;
    	 }
	}
}
