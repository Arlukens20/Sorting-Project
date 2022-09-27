package com.Andrew;

import com.Andrew.SortingClasses.BubbleSort;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	System.out.println("Please insert an Array: ");
    Scanner scan = new Scanner(System.in);
    String str = scan.nextLine();


    //[1,2,4,56,12,432,1234,543,124,6534,9413,134,3]
    //Parse string into an array.
    String[] string = str.replaceAll("\\[", "")
                .replaceAll("]", "")
                .split(",");

    // declaring an array with the size of string
    int[] array = new int[string.length];

    for (int i = 0; i < string.length; i++) {
            array[i] = Integer.valueOf(string[i]);
    }

    System.out.println(" You provided : " + array);
    System.out.println("What kind of sort would you like to do?");
    System.out.println("1: Simple Sort");
    System.out.println("2: Bubble Sort");
    System.out.println("3: Quick Sort");
    int i = scan.nextInt();

    switch (i){
        case 1:
            Arrays.sort(array);
            break;
        case 2:
            BubbleSort bub = new BubbleSort();
            bub.BuSort(array);
            break;
        case 3:

            break;
        default:
            System.out.println("Index "+ i +"is not implemented Please try again.");
    }
    System.out.println("Working ...");

    System.out.println(" Your Sorted Array is : ");
    for(int j = 0; j < array.length;j++){
        System.out.print(array[j]+",");
    }
    }
}
