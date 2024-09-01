package Exception;

public class Ans4
{
    public static void main(String[] args) 
    {
    	try 
    	{
    		int[] a = new int[5];
	    	try 
	       	 {
	              
	              a[5] = 30 / 0;
	         } 
	       	 catch (ArithmeticException e) 
	       	 {
	                System.out.println("Inner try-catch: ArithmeticException: " + e.getMessage());
	         } 
	       	 catch (ArrayIndexOutOfBoundsException e) 
	       	 {
	                System.out.println("Inner try-catch: ArrayIndexOutOfBoundsException: " + e.getMessage());
	         }
	    } 
    	catch (ArrayIndexOutOfBoundsException e) 
    	{
    		 System.out.println("Outer try-catch: ArrayIndexOutOfBoundsException: " + e.getMessage());
		}
    	catch (ArithmeticException e) 
    	{
    		System.out.println("Outer try-catch: ArithmeticException: " + e.getMessage());
		}
    	 
    }
  }
    

