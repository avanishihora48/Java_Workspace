package Task;

import java.util.Scanner;

public class Table {
    public static void main(String[] args) {
		
    	Scanner tab = new Scanner(System.in);
    	
    	System.out.println("Enter the number: ");
    	int num = tab.nextInt();
    	for(int i=1 ;i<=10 ;i++) {
    		System.err.println(+ num +" * " + i + " = " + (num * i));
    	}
	}
}
