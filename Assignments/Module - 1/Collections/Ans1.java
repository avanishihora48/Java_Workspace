package Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Ans1 
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
		
        Iterator i = a.iterator();
		
        int index = 1;
        
		while(i.hasNext())
		{
			System.out.println("color " + index + " = " + i.next());
            index++;  
		}
	}
}
