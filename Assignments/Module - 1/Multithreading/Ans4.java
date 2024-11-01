package Multithreading;

class TestThreadTwice1 extends Thread
{
	@Override
	public void run() 
	{
		System.out.println("Thread is running.....");
	}
}

public class Ans4 
{
    public static void main(String[] args) 
    {
    	TestThreadTwice1 t1 = new TestThreadTwice1();
    	
    	t1.start();
    	t1.start();
	}
}
