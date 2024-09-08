package String;

public class Ans12 
{
		public void printn(int number) 
		{
		     System.out.println("Integer: " + number);
		}

	    public void printn(float number) 
	    {
	        System.out.println("Float: " + number);
	    }

	    public void printn(double number) 
	    {
	        System.out.println("Double: " + number);
	    }

	    public void printn(long number) 
	    {
	        System.out.println("Long: " + number);
	    }

	    public void printn(char character) 
	    {
	        System.out.println("Character: " + character);
	    }

	    public void printn(String text) 
	    {
	        System.out.println("String: " + text);
	    }
	    
	    public void printn(boolean flag) 
	    {
	        System.out.println("Boolean: " + flag);
	    }

	    public static void main(String[] args) {
	       Ans12 printer = new Ans12();
	        
	        printer.printn(5);            
	        printer.printn(3.14f);        
	        printer.printn(9.81);         
	        printer.printn(123456789L);   
	        printer.printn('A');          
	        printer.printn("Hello");      
	        printer.printn(true);         
	    }
}
