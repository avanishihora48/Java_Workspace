package Collection;

import java.util.HashSet;
import java.util.Iterator;

public class Ans12 
{
	 public static void main(String[] args) 
	 {
	        
	        HashSet<String> set = new HashSet<>();
	        set.add("Dog");
	        set.add("Cat");
	        set.add("Bird");
	        set.add("Fish");

	        System.out.println("HashSet: " + set);

	        System.out.println("Iterating using Iterator:");
	        Iterator<String> iterator = set.iterator();
	        while (iterator.hasNext()) {
	            System.out.println(iterator.next());
	        
	   }
	}
}
