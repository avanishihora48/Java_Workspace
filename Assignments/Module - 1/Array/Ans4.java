package Array;

import java.util.Scanner;

public class Ans4 
{
    public static void main(String[] args) 
    {
        int[][] a = new int[2][2];
        int[][] b = new int[2][2];
        int[][] sum = new int[2][2];
        int[][] difference = new int[2][2];
        int[][] product = new int[2][2];
        Scanner sc = new Scanner(System.in);

        
        System.out.println("Enter first matrix numbers: ");
        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < 2; j++) 
            {
                a[i][j] = sc.nextInt();
            }
        }

       
        System.out.println("Enter second matrix numbers: ");
        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < 2; j++) 
            {
                b[i][j] = sc.nextInt();
            }
        }


        System.out.println("Sum of two matrices: ");
        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < 2; j++) 
            {
                sum[i][j] = a[i][j] + b[i][j];
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }

        
        System.out.println("Subtraction of two matrices: ");
        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < 2; j++) 
            {
                difference[i][j] = a[i][j] - b[i][j];
                System.out.print(difference[i][j] + " ");
            }
            System.out.println();
        }

        // Matrix multiplication
        System.out.println("Multiplication of two matrices: ");
        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < 2; j++) 
            {
                product[i][j] = 0; 
                for (int k = 0; k < 2; k++) 
                {
                    product[i][j] += a[i][k] * b[k][j];
                }
                System.out.print(product[i][j] + " ");
            }
            System.out.println();
        }
        
       
    }
}
