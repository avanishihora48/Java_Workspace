package Collection;

import java.util.ArrayList;
import java.util.Collections;

public class Ans19 
{
   public static void main(String[] args) 
   {
	        ArrayList<String> list = new ArrayList<>();
	        list.add("Apple");
	        list.add("Banana");
	        list.add("Mango");
	        list.add("Grapes");
	        list.add("Orange");

	        System.out.println("Original ArrayList: " + list);
	        
	        int index1 = 1; 
	        int index2 = 3; 

	        Collections.swap(list, index1, index2);

	        System.out.println("ArrayList after swapping: " + list);
	    }
   }

