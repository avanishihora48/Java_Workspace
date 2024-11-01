package Collection;

import java.util.ArrayList;

public class Ans24 
{
   public static void main(String[] args) 
   {
	        ArrayList<Integer> list = new ArrayList<>();

	        for (int i = 0; i < 10; i++) 
	        {
	            list.add(i);
	        }

	        System.out.println("ArrayList before resizing: " + list);

	        for (int i = 10; i < 20; i++) 
	        {
	            list.add(i);
	        }

	        System.out.println("ArrayList after resizing: " + list);
	    
   }
}
