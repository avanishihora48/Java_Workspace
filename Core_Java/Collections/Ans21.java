package Collection;

import java.util.HashSet;

public class Ans21
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
            
            String[] array = set.toArray(new String[0]);

            System.out.println("Converted Array: ");
            for (String element : array) 
            {
                System.out.println(element);
            }
	   }
}
