package com.dark.knight.learn.algorithms.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    private static List<int[]> list;
    public static void main(String[] args) {


        Sort quickSort = new QuickSort();
        Sort mergeSort = new MergeSort();
        Sort heapSort = new HeapSort();


        for (int[] array : list) {

            int[] quickArray = Arrays.copyOf(array, array.length);
            int[] mergeArray = Arrays.copyOf(array, array.length);
            int[] heapArray = Arrays.copyOf(array, array.length);

            quickSort.sort(quickArray);

            mergeSort.sort(mergeArray);

            heapSort.sort(heapArray);

            for (int i = 0; i < array.length; i++) {
                if (quickArray[i] != mergeArray[i]) {
                    System.err.println("error:" + i);
                }
            }
        }
       // mergeSort.sort(array);

    }

    static

    {

        list = new ArrayList<>();

        int[] a1 = {1,3,4,1,0,7};
        int[] a2 = {1,1,1,1,11,1,1,1,1,1};
        int[] a3 = {9,8,7,6,5,4,3,2,1};
        int[] a4 = {-1,-2,-4,-5,-7,-8};
        int[] a5 = {5,4,3,2,1,6,7,8,9};

        list.add(a1);
        list.add(a2);
        list.add(a3);
        list.add(a4);
        list.add(a5);

    }
}
