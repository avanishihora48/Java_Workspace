package OOP;

import java.util.Scanner;

public class Ans1
{
    
	int length,breadth;
	int side;
	
	public void printArea(int l,int b)
	{
		length = l;
		breadth = b;
		
		int area = length * breadth;
		System.out.println("Area of reactangle is: "+area);
		
	}
	
	public void printArea(int s) {
		side = s;
		int sq = side*side;
		System.out.println("Area of square is: "+sq);
	}
	
	public static void main(String[] args) 
	{
         
		Scanner s1 = new Scanner(System.in);
		System.out.print("Enter the length of reactangle: ");
		int l1 = s1.nextInt();
		
		System.out.print("Enter the breadth of rectangle: ");
		int b1 = s1.nextInt();
		
		Ans1 print = new Ans1();
		
		print.printArea(l1, b1);
		
		System.out.print("Enter the Side of square: ");
		int s = s1.nextInt();
		
		print.printArea(s);
		
	}
}
