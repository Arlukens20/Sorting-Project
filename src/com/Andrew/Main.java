package com.Andrew;

import com.Andrew.SortingClasses.BubbleSort;
import com.Andrew.SortingClasses.InsertSort;
import com.Andrew.SortingClasses.QuickSort;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

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

        System.out.println(" You provided : " );
        displayArray(array);

        System.out.println("What kind of sort would you like to do?");
        System.out.println("1: Simple Sort");
        System.out.println("2: Bubble Sort");
        System.out.println("3: Quick Sort");
        System.out.println("4: Insert Sort");
        int i = scan.nextInt();

        System.out.println("Working ...");

        long startTime = System.currentTimeMillis();

        switch (i) {
            case 1:
                Arrays.sort(array);
                break;
            case 2:
                BubbleSort bub = new BubbleSort();
                bub.BuSort(array);
                break;
            case 3:
                QuickSort qs = new QuickSort();
                qs.quickSort(array, 0, array.length - 1);
                break;
            case 4:
                InsertSort in = new InsertSort();
                in.insertionSort(array, array.length);
                break;
            default:
                System.out.println("Index " + i + "is not implemented Please try again.");
        }
        long endTime = System.currentTimeMillis();

        //Display Array
        System.out.println("Your Sorted Array is : ");
        displayArray(array);
        buildChart(array);

        //Time Calculator
        long totalTime = endTime - startTime;
        System.out.println("Total Time: " + totalTime + " MilliSeconds");
    }

    public static void displayArray(int[] array){
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j]);
            if(j < array.length - 1){
                System.out.print(',');
            }
        }
        System.out.println("");
    }


    public static void buildChart(int [] array) {

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Array");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 300);

        String title = "My Title";
        String[] labels = new String[]{"num"};
        Color[] colors = new Color[]{
                Color.red,
        };

        BarChart bc = new BarChart(array, labels, colors, title);

        frame.add(bc);
        frame.setVisible(true);
    }
}
