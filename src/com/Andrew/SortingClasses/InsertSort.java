package com.Andrew.SortingClasses;
//Code from https://www.geeksforgeeks.org/insertion-sort/

public class InsertSort {
   public void insertionSort(int arr[], int n)
    {
        int i = 0;
        int key = 0;
        int j = 0;
        for (i = 1; i < n; i++)
        {
            key = arr[i];
            j = i - 1;

            while (j >= 0 && arr[j] > key)
            {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;

            //Print the array here?
            for(int index: arr){
                System.out.print(index + " ");
            }
            System.out.println();
        }
    }
}
