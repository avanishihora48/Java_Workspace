package Multithreading;

class A1 extends Thread
{
	@Override
	public void run() 
	{
		System.out.println("A1 thread running...");
	}
}

class A2 extends Thread
{
	@Override
	public void run() 
	{
		System.out.println("A2 thread running...");
	}
}
public class Ans2 
{
     public static void main(String[] args) 
     {
		 A1 a1 = new A1();
		 A2 a2 = new A2();
		 
		 a1.start();
		 a2.start();
	 }
}
