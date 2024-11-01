package Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Ans22 
{
	public static void main(String[] args) 
	{
        HashSet<String> set = new HashSet<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Mango");
        set.add("Grapes");
        set.add("Orange");

        System.out.println("Original HashSet: " + set);

        List<String> list = new ArrayList<>(set);

        Collections.sort(list);
        System.out.println("Converted ArrayList: " + list);
    }
}
