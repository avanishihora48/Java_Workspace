package Collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Ans3 
{
    public static void main(String[] args) 
    {
		LinkedList<String>list = new LinkedList<>();
		
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.addFirst("6");
		
		Iterator<String> i = list.iterator();
		
		while(i.hasNext())
		{
			System.out.println(i.next());
		}
	}
}
