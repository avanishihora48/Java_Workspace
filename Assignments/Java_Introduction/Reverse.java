package Task;

import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
		
    	Scanner rev = new Scanner(System.in);
    	
    	System.out.println("Enter the number: ");
    	int num = rev.nextInt();
    	
    	int revNum  = 0;
    	
    	while(num != 0) {
    		int digit = num % 10;
    		revNum = revNum * 10 + digit;
    		 num /= 10;
    	}
    	
    	System.out.println("Reverse number is: "+revNum);
    	
	}
}
