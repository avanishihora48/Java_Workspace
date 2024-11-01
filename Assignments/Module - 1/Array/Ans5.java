package Array;

import java.util.Scanner;

public class Ans5 
{
	public static int findLength(String str)
	{
		int length = 0;
		
		for(int i = 0; i<str.length(); i++)
		{
			length++;
		}
		return length ;
		
	}
    public static void main(String[] args) 
    {
    	Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String input = sc.nextLine();
        
        int length = findLength(input);
        System.out.println("Length of the string is: " + length);

	}
}
