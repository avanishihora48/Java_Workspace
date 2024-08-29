package OOP;

import java.util.Scanner;

abstract class Shape
{
	abstract void RectangleArea(double length, double breadth);
	abstract void SquareArea(double side);
	abstract void CircleArea(double radius);
}

class Area extends Shape
{
	double length,breadth;
	
	void RectangleArea(double length, double breadth)
	{
		double area = length * breadth;
		System.out.println("Area of rectangle is: "+area);
	}
	
	void SquareArea(double side)
	{
		double area = side * side;
		System.out.println("Area of rectangle is: "+area);
	}
	
	void CircleArea(double radius)
	{
		double area = Math.PI * radius * radius;
		System.out.println("Area of rectangle is: "+area);
	}
}
public class Ans11 
{
    public static void main(String[] args) 
    {
		Scanner sc = new Scanner(System.in);
		
		Area a = new Area();
		
		 System.out.print("Enter the length and breadth of the rectangle:");
	     double length = sc.nextDouble();
	     double breadth = sc.nextDouble();
	     a.RectangleArea(length, breadth);

	        
	     System.out.print("Enter the side length of the square:");
	     double side = sc.nextDouble();
	     a.SquareArea(side);

	       
	     System.out.print("Enter the radius of the circle:");
	     double radius = sc.nextDouble();
	     a.CircleArea(radius);
	}
}
