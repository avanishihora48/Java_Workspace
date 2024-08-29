package OOP;

class Triangle 
{
    int a = 3;
    int b = 4;
    int c = 5;

    
    public int Perimeter() 
    {
        return a + b + c;
    }

    
    public double Area() 
    {
        int s = Perimeter() / 2; 
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}

public class Ans5 
{
    public static void main(String[] args) {
        Triangle t = new Triangle();

        System.out.println("Perimeter of triangle: " + t.Perimeter());
        System.out.println("Area of triangle: " + t.Area());
    }
}
