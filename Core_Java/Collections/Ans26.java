package Collection;

import java.util.ArrayList;

public class Ans26 
{
	 public static void main(String[] args) 
	 {
	        ArrayList<String> list = new ArrayList<>();
	        list.add("Apple");
	        list.add("Banana");
	        list.add("Cherry");
	        list.add("Chikuu");

	        for (int i = 0; i < list.size(); i++) 
	        {
	            System.out.println("Position " + i + ": " + list.get(i));
	        }
	    }
}
