package Collection;

import java.util.HashMap;

public class Ans15 
{
	public static void main(String[] args) 
	{
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Apple", 3);
        map.put("Banana", 2);
        map.put("Mango", 5);
        map.put("Grapes", 4);

        System.out.println("HashMap: " + map);

        int size = map.size();

        System.out.println("Number of key-value mappings in the HashMap: " + size);
    }
}
