package Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Ans2 
{
	 public static void main(String[] args) 
	    {
			ArrayList<String> a = new ArrayList<>();
			
			Scanner sc = new Scanner(System.in);
		
			System.out.println("Enter color: ");
			
			for(int i = 0; i < 5; i++)
			{
				String color = sc.next();
				
				a.add(color);
			}
			
			Iterator<String> iterator = a.iterator();
	       
	        int index = 1;
			while(iterator.hasNext())
			{
				System.out.println("color " + index + " = " +iterator.next()); 
				index++;
			}
		}
}
