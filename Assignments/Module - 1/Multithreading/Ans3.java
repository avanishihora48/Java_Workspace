package Multithreading;

class X extends Thread
{
	public void run() 
	{
        System.out.println("X thread is running....");
        
        try 
        {
			Thread.sleep(2000);
			 System.out.println("X thread finished after 2 seconds.");
		} 
        catch (Exception e) 
        {
			System.out.println("X thread interrupted");
		}
	}
}

class Y extends Thread
{
	public void run() 
	{
		System.out.println("Y thread is running...");
		
		try 
		{
			Thread.sleep(2000);
			System.out.println("Y thread finished after 2 seconds. ");
		} 
		catch (Exception e) 
		{
			System.out.println("Y thread interrupted");
		}
	}
}

public class Ans3 
{
    public static void main(String[] args) 
    {
		X x = new X();
		Y y = new Y();
		
		x.start();
		y.start();
	}
}
