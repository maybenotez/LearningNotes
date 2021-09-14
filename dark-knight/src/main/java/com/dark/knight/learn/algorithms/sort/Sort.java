package com.dark.knight.learn.algorithms.sort;

public interface Sort {

    void sort(int[] array);


    default void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
