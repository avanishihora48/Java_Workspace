package Collection;

import java.util.HashMap;
import java.util.Map;

public class Ans23 
{
	public static void main(String[] args) 
	{
        Map<String, String> map = new HashMap<>();
        map.put("Name", "John");
        map.put("Age", "30");
        map.put("City", "New York");

        boolean isEmpty = map.isEmpty();
        System.out.println("Is the map empty? : " + isEmpty);

        map.clear();

        isEmpty = map.isEmpty();
        System.out.println("Is the map empty after clearing?: " + isEmpty);
    }
}
