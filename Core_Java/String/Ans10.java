package String;

import java.util.ArrayList;

public class Ans10 
{
	public static void main(String[] args) 
	{
        String s1 = "WX";
        String s2 = "YZ";
        ArrayList<String> results = new ArrayList<>();
        interleave(s1, s2, "", results);
        System.out.println(results);
    }

    public static void interleave(String s1, String s2, String prefix, ArrayList<String> results) 
    {
        if (s1.isEmpty() && s2.isEmpty()) {
            results.add(prefix);
            return;
        }
        if (!s1.isEmpty()) {
            interleave(s1.substring(1), s2, prefix + s1.charAt(0), results);
        }
        if (!s2.isEmpty()) {
            interleave(s1, s2.substring(1), prefix + s2.charAt(0), results);
        }
    }
}
