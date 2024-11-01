package Collection;

import java.util.ArrayList;

public class Ans20 
{
	public static void main(String[] args) 
	{
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("Monday");
        list1.add("Tuesday");
        list1.add("Wednesday");

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("Thursday");
        list2.add("Friday");
        list2.add("Saturday");

        System.out.println("List1: " + list1);
        System.out.println("List2: " + list2);

        list1.addAll(list2);

        System.out.println("Joined ArrayList: " + list1);
    }
}
