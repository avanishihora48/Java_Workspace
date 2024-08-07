package Module2;

public class Ans7 
{
    public static void main(String[] args) 
    {
        int count = 1;
        for (int i = 1; count <= 10; i++) 
        {
            for (int j = 1; j <= i; j++) 
            {
                System.out.print(count + " ");
                count++;
            }
            System.out.println(); 
        }
    }
}

