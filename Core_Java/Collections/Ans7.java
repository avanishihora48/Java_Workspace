package Collection;

import java.util.ArrayList;
import java.util.Scanner;

public class Ans7 
{
    public static void main(String[] args) 
    {
    	ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Grapes");
        list.add("Watermalon");
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the element to search: ");
        String searchElement = scanner.nextLine();
        
        if(list.contains(searchElement))
        {
        	 System.out.println(searchElement + " is found in the list.");
        }
        else {
            System.out.println(searchElement + " is not found in the list.");
        }

	}
}
