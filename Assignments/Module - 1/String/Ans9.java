package String;

public class Ans9 
{
    public static void main(String[] args) 
    {
		String str1 = "Red is my favorite color";
		String pr1 = "Red";
		
		String str2 = "Orange is also my favorite color";
		String pr2 = "Red";
		
		boolean s1 = str1.startsWith(pr1);
		boolean s2 = str2.startsWith(pr2);
		
		System.out.println("\"" + str1 + "\" starts with \"" + pr1 + "\"? : " + s1);
		System.out.println("\"" + str2 + "\" starts with \"" + pr2 + "\"? : " + s2);
	}
}
