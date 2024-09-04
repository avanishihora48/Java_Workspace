package Collection;

import java.util.ArrayList;

public class Ans5 
{
	public static void main(String[] args) 
    {
    	 ArrayList<String> list = new ArrayList<>();
         list.add("Apple");
         list.add("Banana");
         list.add("Cherry");
         list.add("Grapes");
         list.add("Watermalon");
         
         int index = 2;
         
         String newElement = "Mango";
         
         if (index >= 0 && index < list.size()) 
         {
             list.set(index, newElement);
             System.out.println("Updated List: " + list);
         } 
         else 
         {
             System.out.println("Index out of bounds.");
         }
	}
}
