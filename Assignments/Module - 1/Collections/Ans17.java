package Collection;

import java.util.ArrayList;
import java.util.List;

public class Ans17 
{
    public static void main(String[] args) 
    {
    	ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Mango");
        list.add("Grapes");
        list.add("Orange");
        list.add("Pineapple");
        list.add("Strawberry");

        System.out.println("Original ArrayList: " + list);

        int startIndex = 2;
        int endIndex = 5;

        List<String> subList = list.subList(startIndex, endIndex);

        System.out.println("Extracted portion: " + subList);
    }
}

