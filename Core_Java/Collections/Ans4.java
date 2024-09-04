package Collection;

import java.util.ArrayList;

public class Ans4 
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
         
         if (index >= 0 && index < list.size()) 
         {
             String element = list.get(index);
             System.out.println("Element at index " + index + ": " + element);
         } 
         else 
         {
             System.out.println("Index out of bounds.");
         }
	}
}
