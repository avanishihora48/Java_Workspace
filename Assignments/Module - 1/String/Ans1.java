package String;

import java.util.Scanner;

public class Ans1 
{
    public static void main(String[] args) 
    {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the sentence: ");
		String input = sc.nextLine();
		
		int letters = 0, spaces = 0, numbers = 0, others = 0;
		
		for(int i=0 ; i<input.length(); i++)
		{
			char ch = input.charAt(i);
			
			if(Character.isLetter(ch))
			{
				letters++;
			}
			else if(Character.isDigit(ch))
			{
				numbers++;
			}
			else if(Character.isWhitespace(ch))
			{
				spaces++;
			}
			else
			{
				others++;
			}
		}
		
		System.out.println("Letters: " + letters);
	    System.out.println("Spaces: " + spaces);
	    System.out.println("Numbers: " + numbers);
	    System.out.println("Other characters: " + others);
	    
	}
}
