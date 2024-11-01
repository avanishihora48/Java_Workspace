package Collection;

import java.util.ArrayList;

public class Ans25 
{
	public static void main(String[] args) 
	{
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Date");

        System.out.println("ArrayList before replacement: " + list);

        if (list.size() > 1) 
        {
            list.set(1, "Blueberry");
        } 
        else 
        {
            System.out.println("The list does not have a second element.");
        }

        System.out.println("ArrayList after replacement: " + list);
    }
}
