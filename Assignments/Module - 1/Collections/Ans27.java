package Collection;

import java.util.HashSet;
import java.util.Set;

public class Ans27 
{
	 public static void main(String[] args) 
	 {  
	        Set<String> set1 = new HashSet<>();
	        set1.add("1");
	        set1.add("5");
	        set1.add("6");
	        set1.add("4");

	        Set<String> set2 = new HashSet<>();
	        set2.add("5");
	        set2.add("6");
	        set2.add("7");
	        set2.add("1");

	        System.out.println("Original Set 1: " + set1);
	        System.out.println("Original Set 2: " + set2);

	        set1.retainAll(set2);

	        System.out.println("Common elements in both sets: " + set1);
	    }
}
