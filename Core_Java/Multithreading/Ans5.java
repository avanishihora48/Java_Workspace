package Multithreading;

class TestDaemonThread2 extends Thread
{
	@Override
	public void run() 
	{
		if(isDaemon())
		{
			System.out.println(Thread.currentThread().getName() + " is a daemon thread");
		}
		else
		{
			System.out.println(Thread.currentThread().getName() + " is a user thread.");
		}
	}
}

public class Ans5 
{
    public static void main(String[] args) 
    {
    	TestDaemonThread2 t1 = new TestDaemonThread2();
    	TestDaemonThread2 t2 = new TestDaemonThread2();
    	
    	t1.setDaemon(true);
    	
    	t1.start();
    	t2.start();
    	
    	 System.out.println("Thread t1 isDaemon: " + t1.isDaemon());
         System.out.println("Thread t2 isDaemon: " + t2.isDaemon());
	}
}
