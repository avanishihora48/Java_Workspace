package Collection;

import java.util.ArrayList;

public class Ans18 
{
   public static void main(String[] args) 
   {
	        ArrayList<String> list1 = new ArrayList<>();
	        list1.add("Apple");
	        list1.add("Banana");
	        list1.add("Mango");
	        
	        ArrayList<String> list2 = new ArrayList<>();
	        list2.add("Apple");
	        list2.add("Banana");
	        list2.add("Mango");

	        ArrayList<String> list3 = new ArrayList<>();
	        list3.add("Apple");
	        list3.add("Banana");
	        list3.add("Grapes");

	        boolean areEqual1 = list1.equals(list2);
	        System.out.println("List1 and List2 are equal: " + areEqual1);

	        boolean areEqual2 = list1.equals(list3);
	        System.out.println("List1 and List3 are equal: " + areEqual2);

	        boolean list1ContainsAllList3 = list1.containsAll(list3);
	        System.out.println("List1 contains all elements of List3: " + list1ContainsAllList3);

	        boolean list3ContainsAllList1 = list3.containsAll(list1);
	        System.out.println("List3 contains all elements of List1: " + list3ContainsAllList1);
	    
   }
}
