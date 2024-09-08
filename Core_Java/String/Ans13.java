package String;

public class Ans13 
{
		public void print(int n, char c) 
		{
		    System.out.println("Integer: " + n + ", Character: " + c);
		}

	   
	    public void print(char c, int n) 
	    {
	        System.out.println("Character: " + c + ", Integer: " + n);
	    }

	    public static void main(String[] args) 
	    {
	        Ans13 printer = new Ans13();
	        
	        printer.print(100, 'A');

	        printer.print('B', 200);
	    }
}
