package Exception;

import java.util.Scanner;

public class Ans7 {
    private int totalbal = 0;

    public int balance() 
    {
        return totalbal;
    }

    public void deposit(int amount) 
    {
        totalbal += amount;
        System.out.println("Deposited: " + amount + ". New balance: " + totalbal);
    }

    
    public void withdraw(int amount) throws InsufficientFundException 
    {
        if (amount > totalbal) 
        {
            throw new InsufficientFundException(String.format("Insufficient balance. You need %d rs more to perform this transaction.", (amount - totalbal)));
        } 
        else 
        {
            totalbal -= amount;
            System.out.println("Withdrawn: " + amount + ". Remaining balance: " + totalbal);
        }
    }

    public static void main(String[] args) 
    {
        Ans7 account = new Ans7();
        Scanner sc = new Scanner(System.in);

        try 
        {
            System.out.println("Enter the deposit amount:");
            int depositAmount = sc.nextInt();
            account.deposit(depositAmount);

            System.out.println("Enter the withdrawal amount:");
            int withdrawAmount = sc.nextInt();
            account.withdraw(withdrawAmount);

        } 
        catch (InsufficientFundException e) 
        {
           System.out.println(e.getMessage());
        } 
        
    }
}
