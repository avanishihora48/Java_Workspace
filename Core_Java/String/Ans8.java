package String;

public class Ans8 
{
    public static void main(String[] args) 
    {
		String s1 = "Java Excercises";
		String a1 = "se";
		
		String s2 = "Java Excercise";
		String a2 = "se";
		
		boolean E1 = s1.endsWith(a1);
		boolean E2 = s2.endsWith(a2);
		
		System.out.println("\"" + s1 + "\" ends with \"" + a1 + "\"? : " + E1);
        System.out.println("\"" + s2 + "\" ends with \"" + a2 + "\"? : " + E2);
	}
}
