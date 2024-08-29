package OOP;

abstract class AbstractParent 
{
    abstract void message();
}


class FirstSubClass extends AbstractParent 
{
    @Override
    void message() 
    {
        System.out.println("This is first subclass.");
    }
}


class SecondSubClass extends AbstractParent 
{
    @Override
    void message() 
    {
        System.out.println("This is second subclass.");
    }
}

public class Ans7 
{
    public static void main(String[] args)
    {
        AbstractParent first = new FirstSubClass();
        first.message();

        AbstractParent second = new SecondSubClass();
        second.message();
    }
}
