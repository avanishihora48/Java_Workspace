package Array;

import java.util.Scanner;

public class Ans2 
{
    public static void findSecondMax(int[] arr)
    {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] > largest)
            {
                secondLargest = largest;
                largest = arr[i];
            }
            else if(arr[i] > secondLargest && arr[i] != largest)
            {
                secondLargest = arr[i];
            }
        }
        
        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("No second largest element found.");
        } else {
            System.out.println("The second largest element is: " + secondLargest);
        }
    }
    
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the size of an array: ");
        int n = sc.nextInt();
        
        int[] numbers = new int[n];
        
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) 
        {
            numbers[i] = sc.nextInt();
        }
        
        System.out.print("The elements of the array are: ");
        for (int i = 0; i < n; i++) 
        {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
        
        findSecondMax(numbers);
        
    }
}
