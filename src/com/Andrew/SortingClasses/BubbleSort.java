package com.Andrew.SortingClasses;

public class BubbleSort extends Sort{
    //Need to keep track of each iteration?
    //Build a constructor

    public void BuSort(int[] array){
        int iteration = 0;

        do{
            for(int i = 0; i < array.length -1; i++){
                int temp;
                if(array[i] > array[i+1]){
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }

            //Print out for Decoding
            for(int i: array){
                System.out.print(i + " ");
            }

           //check sorted here?
            iteration++;
        }while(checkNotSorted(array));

        System.out.println("Took " + iteration + " Iterations");
    }
}
