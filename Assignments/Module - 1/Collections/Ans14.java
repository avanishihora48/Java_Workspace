package Collection;

import java.util.HashMap;

public class Ans14 
{
	 public static void main(String[] args) 
	 {
	      
	        HashMap<Integer, String> map = new HashMap<>();
	        
	        map.put(1, "Riya");
	        map.put(2, "Alia");
	        map.put(3, "Rohan");

	        System.out.println("Original HashMap: " + map);

	        int key = 4;
	        String value = "Siya";
	        map.put(key, value);
	        
	        System.out.println("Updated HashMap: " + map);
	    }
}
