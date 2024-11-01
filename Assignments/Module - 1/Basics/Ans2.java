package Module2;

import java.util.Scanner;

public class Ans2
{
    public static void main(String[] args)
    {
		Scanner a = new Scanner(System.in);
		
		System.out.print("Enter Single character: ");
		String a1 = a.next();
		
		if(a1.length()>1) 
		{
			System.out.println("Please enter single character only");
		}
		else
		{
			char ch = a1.charAt(0);
		
		  if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
		  {

				if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
				   || ch == 'A'||ch == 'E'|| ch == 'I' ||ch == 'O' ||ch == 'U' )
				{
					System.out.println("This is Vowel");
				}
				else 
				{
					System.out.println("This is Consonent");
				}
		  }
		  else 
		  {
			  System.out.println("Error: Please enter a valid letter between a and z or A and Z.");
		  }
		}
	}
}
