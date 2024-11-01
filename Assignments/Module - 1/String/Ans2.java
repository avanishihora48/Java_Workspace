package String;

import java.util.Scanner;

public class Ans2 
{
    public static void main(String[] args) 
    {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter character to know its ASCII value: ");
		char ch = sc.next().charAt(0);
		
		int asciiValue = (int)ch;
		
		System.out.println("The ASCII value of "+ ch +" is: "+asciiValue);
	}
}
