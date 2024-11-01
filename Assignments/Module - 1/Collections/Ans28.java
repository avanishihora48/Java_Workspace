package Collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Ans28 
{
	public static void main(String[] args) 
	{
        Map<String, Integer> map = new HashMap<>();
        map.put("Avani", 1);
        map.put("Shreya", 2);
        map.put("Jinkal", 3);
        map.put("Dhwani", 4);

        Collection<Integer> values = map.values();

        System.out.println("Values in the map: " + values);
    }
}
