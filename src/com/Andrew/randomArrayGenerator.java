package com.Andrew;

import java.util.Arrays;

public class randomArrayGenerator {

    public int[] generateArray(int length,int distribution){
        int[] array = new int[length];

        for(int i = 0; i < array.length; i++){
            double doubleRandomNumber = Math.random() * 100;
            int randomNumber = (int)doubleRandomNumber;
            array[i] = randomNumber;
        }

        return array;
    }

    public String convertToString(int[] array){
        return Arrays.toString(array);
    }
}
