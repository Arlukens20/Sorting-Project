package com.Andrew.SortingClasses;

public class QuickSort{




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
}

