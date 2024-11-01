package Multithreading;

class MyRunnable implements Runnable
{
	@Override
	public void run() 
	{
		System.out.println("Thread is running...");
	}	
}


public class Ans1 
{
    public static void main(String[] args) 
    {
    	MyRunnable m = new MyRunnable();
    	
    	Thread t = new Thread(m);
    	
    	t.start();
	}
}
