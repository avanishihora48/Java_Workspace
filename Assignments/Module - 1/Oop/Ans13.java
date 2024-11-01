package OOP;

class Shape1
{
	public void PrintShape()
	{
		System.out.println("This is shape");
	}
}

class Rectangle extends Shape1
{
	public void printRectangle()
	{
		System.out.println("This is rectangular shape");
	}
}

class Circle extends Shape1
{
	public void printCircle()
	{
		System.out.println("This is circular shape");
	}
}

class Square extends Rectangle
{
	public void printSquare()
	{
		System.out.println("Square is a Rectangle");
	}
}
public class Ans13 
{
    public static void main(String[] args) 
    {
		Square s = new Square();
		s.printRectangle();
		s.PrintShape();
		s.printSquare();
	}
}
