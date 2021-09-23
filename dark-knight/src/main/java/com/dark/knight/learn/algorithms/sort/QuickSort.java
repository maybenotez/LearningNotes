package com.dark.knight.learn.algorithms.sort;

public class QuickSort implements Sort{

    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }


    private void quickSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int partition = getPartition(array, low, high);
        quickSort(array, low, partition - 1);
        quickSort(array, partition + 1, high);
    }

    private int getPartition(int[] array,int low,int high) {

        int key = array[low];

        while (low<high){

            while(high>low && array[high]>= key){
                high--;
            }

            array[low] = array[high];

            while(low< high && array[low] <= key){
                low++;
            }
            array[high] = array[low];
        }

        array[low] = key;

        return low;
    }

    public static void main(String[] args) {

        QuickSort sort = new QuickSort();
        int[] array = {3, 4, 5, 6, 7, 1, 9};
        sort.sort(array);
    }


}
