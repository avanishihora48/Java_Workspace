package Array;

import java.util.Scanner;

public class Ans6 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
    
        System.out.print("Enter a string: ");
        String str = sc.nextLine(); 
        
        String rev = "";
        
        for(int i = str.length() - 1; i >= 0; i--) 
        {
            rev += str.charAt(i);
        }
        
        System.out.println("Reverse string is: " + rev);
        
        if(str.equals(rev)) 
        {
            System.out.println("Palindrome String");
        } 
        else 
        {
            System.out.println("Not a Palindrome String");
        }
        
        sc.close(); 
    }
}
