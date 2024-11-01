package OOP;

import java.util.Scanner;

class Complex
{
	double real;
	double imaginary;
	
	public Complex(double real,double imaginary)
	{
		this.real = real;
		this.imaginary = imaginary;
	}
	
	public static Complex sub(Complex c1, Complex c2)
	{
		double newReal = c1.real - c2.real;
		double newImaginary = c1.imaginary - c2.imaginary;
		return new Complex( newReal , newImaginary);
	}
	
	public static Complex product(Complex c1, Complex c2)
	{
		double newReal = (c1.real * c2.real) - (c1.imaginary * c2.imaginary);
		double newImaginary = (c1.real * c2.real) + (c1.imaginary * c2.imaginary);
		return new Complex( newReal , newImaginary);
	}
	
	public static Complex add(Complex c1, Complex c2)
	{
		double newReal = c1.real + c2.real;
		double newImaginary = c1.imaginary + c2.imaginary;
		return new Complex( newReal , newImaginary);
	}
	
	public String toString()
	{
		return real + " + " + imaginary + "i";
	}
}

public class Ans6 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter your first real number: ");
		double real1 = sc.nextDouble();
		
		System.out.print("Enter your second real number: ");
		double real2 = sc.nextDouble();
		
		System.out.print("Enter your first imaginary number: ");
		double imag1 = sc.nextDouble();
		
		System.out.print("Enter your second imaginary number: ");
		double imag2 = sc.nextDouble();
		
		Complex c1 = new Complex(real1 , imag1);
		Complex c2 = new Complex(real2 , imag2);
		
		Complex sum = Complex.add(c1, c2);
	    Complex difference = Complex.sub(c1, c2);
	    Complex product = Complex.product(c1, c2);

	    System.out.println("Sum: " + sum);
	    System.out.println("Difference: " + difference);
	    System.out.println("Product: " + product);
	}
      
      
}
