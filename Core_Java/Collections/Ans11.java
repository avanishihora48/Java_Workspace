package Collection;

import java.util.HashSet;

public class Ans11 
{
    public static void main(String[] args) 
    {
    	HashSet<String> set = new HashSet<>();
        set.add("Dog");
        set.add("Cat");
        set.add("Bird");

        System.out.println("Original HashSet: " + set);

        String newElement = "Fish";
        set.add(newElement);

        System.out.println("Updated HashSet: " + set);
	}
}
