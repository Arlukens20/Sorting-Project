package com.Andrew.SortingClasses;

//Code from https://www.geeksforgeeks.org/selection-sort/

public class SelectionSort extends Sort{

    public void sort(int arr[])
    {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;

            //Print out for Decoding
            for(int j: arr){
                System.out.print(j + " ");
            }
        }
    }
}
