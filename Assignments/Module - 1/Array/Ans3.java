package Array;

import java.util.Scanner;

public class Ans3 
{
	public static void Ascending(int[] arr)
	{
		int n = arr.length;

		System.out.print("Original array: ");
		for(int i = 0; i < n; i++)
		{
			System.out.print(arr[i] + " ");
		}

		
		int temp;
		for(int i = 0; i < n - 1; i++)
		{
			for(int j = i + 1; j < n; j++)
			{
				if(arr[i] > arr[j]) 
				{
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		System.out.print("\nAscending order: ");
		
		
		
	}
	
	public static void Descending(int[] arr)
	{
	    int n = arr.length;
	    int temp;
	    
		for(int i = 0; i < n; i++)
		{
			System.out.print(arr[i] + " ");
		}
		
		 for(int i = 0; i < n - 1; i++)
	        {
	            for(int j = i + 1; j < n; j++)
	            {
	                if(arr[i] < arr[j]) 
	                {
	                    temp = arr[i];
	                    arr[i] = arr[j];
	                    arr[j] = temp;
	                }
	            }
	        }

	        System.out.print("\nDescending order: ");
	        for(int i = 0; i < n; i++)
	        {
	            System.out.print(arr[i] + " ");
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
        
        Ascending(numbers);
        Descending(numbers);
	}
}
