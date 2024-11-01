package String;

import java.util.Scanner;

public class Ans3 
{
	public static void main(String[] args) 
	{
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.print("Enter the value of n: ");
		 int n = sc.nextInt();
		 
		 String N = Integer.toString(n);
		 String NN = N + N;
		 String NNN = N + N + N;
		 
		 int nn =  Integer.parseInt(NN);
		 int nnn =  Integer.parseInt(NNN);
		 
		 System.out.println(n + " + " + nn + " + " + nnn);
	}   
}
