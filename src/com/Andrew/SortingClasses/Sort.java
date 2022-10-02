package com.Andrew.SortingClasses;

public class Sort {

    public Boolean checkNotSorted(int[] array){
        for(int i = 0; i < array.length - 1; i++){
            if(array[i] > array[i+1]){
//                System.out.println("False");
                return true;
            }
        }
//        System.out.println("True");
        return false;
    }

    public void printArray(int arr[])
    {
        for(int i: arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
