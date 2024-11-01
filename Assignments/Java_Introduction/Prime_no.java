package Task;

import java.util.Scanner;

public class Prime_no {
     public static void main(String[] args) {
		
    	 Scanner pri = new Scanner(System.in);
    	 
    	 System.out.println("Enter the number: ");
    	 int num = pri.nextInt();
    	 int prime = 1;
    	 
    	 if (num <= 1) {
    	        prime = 0; 
    	    } 
    	 else {
    	        for (int i = 2; i <= num / 2; i++) {
    	            if (num % i == 0) {
    	                prime = 0; 
    	           }
    	        }
    	    }
    	 
    	 if (prime == 1) {
             System.out.println("The given number is prime");
         } else {
             System.out.println("The given number is not prime");
         }
     }
   }
     
