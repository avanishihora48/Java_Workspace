package OOP;

abstract class Bank
{
	abstract int getBalance();
}

class BankA extends Bank
{
   private int balance = 100;
    
	@Override
	int getBalance() 
	{
		return balance;
	}
}

class BankB extends Bank
{
    private int balance = 150;
	@Override
	int getBalance() 
	{
		return balance;
	}
}

class BankC extends Bank
{
    private int balance = 200;
	@Override
	int getBalance() 
	{
		return balance;
	}
}

public class Ans8 
{
    public static void main(String[] args) 
    {
		Bank A = new BankA();
		Bank B = new BankB();
		Bank C = new BankC();
		
		System.out.println("Balance in bank A is: "+A.getBalance()+"$");
		System.out.println("Balance in bank B is: "+B.getBalance()+"$");
		System.out.println("Balance in bank C is: "+C.getBalance()+"$");
	}
}
