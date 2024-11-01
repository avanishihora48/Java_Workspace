package OOP;

import java.util.Scanner;

public class Ans12 
{
    public static void main(String[] args) 
    {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your marks out of 100: ");
		int marks = sc.nextInt();
		
		String grade = calGrade(marks);
		System.out.println("Your grade is: "+grade);
	}

	private static String calGrade(int marks)
	{
		if(marks>=91 && marks<=100)
		{
			return "A";
		}
		else if(marks>=81 && marks<=90)
		{
			return "B";
		}
		else if(marks>=71 && marks<=80)
		{
			return "B";
		}
		else if(marks>=61 && marks<=70)
		{
			return "C";
		}
		else if(marks>=51 && marks<=60)
		{
			return "D";
		}
		else if(marks>=41 && marks<=50)
		{
			return "D";
		}
		else if(marks>=0 && marks<=40)
		{
			return "Fail";
		}
		else 
		{
			return "Invalid marks";
		}
	}
}
