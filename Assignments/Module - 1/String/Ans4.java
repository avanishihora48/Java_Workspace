package String;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Ans4 
{
   public static void main(String[] args) 
   {
	   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm:ss a");
	   
	   LocalTime now = LocalTime.now();
	   
	   String FormattedTime = now.format(dtf);
	   System.out.println("Current system time: " + FormattedTime);
	   
	}
}
