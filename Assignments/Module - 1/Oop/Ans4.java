package OOP;

import java.util.Scanner;

public class Ans4 {
    double length;
    double breadth;

    public Ans4(double length, double breadth) 
    {
        this.length = length;
        this.breadth = breadth;
    }
    
    public void Area() 
    {
        double area = length * breadth;
        System.out.println("Area of rectangle is: " + area);
    }

    
    public void Perimeter() 
    {
        double perimeter = 2 * (length + breadth);
        System.out.println("Perimeter of rectangle is: " + perimeter);
    }

    
    public static class Square extends Ans4 {
        
        public Square(double side) 
        {
            super(side, side);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the length of rectangle: ");
        double length = sc.nextDouble();

        System.out.print("Enter the breadth of rectangle: ");
        double breadth = sc.nextDouble();

        Ans4 rectangle = new Ans4(length, breadth);
        rectangle.Area();
        rectangle.Perimeter();

       
        System.out.print("Enter the side of the square: ");
        double side = sc.nextDouble();

        Square square = new Square(side);
        square.Area();
        square.Perimeter();

        
    }
}
