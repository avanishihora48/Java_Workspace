package String;

import java.util.Scanner;

public class Ans7 
{
   public static void main(String[] args) 
   {
	   String s1 = "topsint.com";
       String s2 = "topsint.com";
       String s3 = "Topsint.com";
	   
      boolean comparison1 = s1.equals(s2);
      boolean comparison2 = s1.equals(s3);
      
	  System.out.println(("Comparing " + s1 + " and " + s2 + ": " + comparison1));
	  System.out.println("Comparing " + s3 + " and " + s2 + ": " + comparison2); 
   }
}
