package Task;

import java.util.Scanner;

public class Area {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("1. Area of Triangle");
        System.out.println("2. Area of Rectangle");
        System.out.println("3. Area of Circle");
        System.out.println("Enter your choice : ");
        int choice = sc.nextInt();

        if (choice == 1) 
        {
            System.out.println("Enter the base of the triangle: ");
            double base = sc.nextDouble();
            System.out.println("Enter the height of the triangle: ");
            double height = sc.nextDouble();
            double area = 0.5 * base * height;
            System.out.println("Area of the Triangle is: " + area);
        }
        else if (choice == 2) 
        {
            System.out.println("Enter the length of the rectangle: ");
            double length = sc.nextDouble();
            System.out.println("Enter the width of the rectangle: ");
            double width = sc.nextDouble();
            double area = length * width;
            System.out.println("Area of the Rectangle is: " + area);
        } 
        else if (choice == 3) 
        {
            System.out.println("Enter the radius of the circle: ");
            double radius = sc.nextDouble();
            double area = Math.PI * radius * radius;
            System.out.println("Area of the Circle is: " + area);
        } else
        {
            System.out.println("Invalid choice. Please select 1, 2, or 3.");
        }
    }
}

