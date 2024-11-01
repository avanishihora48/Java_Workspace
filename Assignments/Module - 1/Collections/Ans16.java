package Collection;

import java.util.ArrayList;

public class Ans16 
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

	        ArrayList<String> reversedList = new ArrayList<>();
	        for (int i = list.size() - 1; i >= 0; i--) 
	        {
	            reversedList.add(list.get(i));
	        }

	        System.out.println("Reversed ArrayList: " + reversedList);
	    }
}
