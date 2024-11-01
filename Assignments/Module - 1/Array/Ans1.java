package Array;

import java.util.Scanner;

public class Ans1 
{
    public static int findMax(int[] arr) 
    {
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) 
        {
            if (arr[i] > max) {
                max = arr[i]; 
            }
        }
        return max; 
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();

        int[] numbers = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) 
        {
            numbers[i] = sc.nextInt();
        }

        int maxNumber = findMax(numbers);

        System.out.println("The maximum number in the array is: " + maxNumber);
    }
}
