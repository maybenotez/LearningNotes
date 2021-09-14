package com.dark.knight.learn.algorithms.sort;

public class MergeSort implements Sort{

    private int[] temp;

    @Override
    public void sort(int[] array) {
        temp = new int[array.length];
        mergeSort(array, 0, array.length - 1);
    }


    private void mergeSort(int[] array, int low, int high) {
        if (low == high) {
            return;
        }
        int mid = (low + high) / 2;

        mergeSort(array, low, mid);

        mergeSort(array, mid + 1, high);

        merge(array, low, mid+1 , high);
    }


    public void merge(int[] array,int low,int mid,int high){

        int i = low;
        int j = mid;
        int k = low;

        while (i <= mid-1 && j <= high) {

            if(array[i] > array[j]){
                temp[k] = array[j];
                j++;
            }else{
                temp[k] = array[i];
                i++;
            }
            k++;
        }

        while(i<=mid-1){
            temp[k] = array[i];
            i++;
            k++;
        }
        while (j <= high) {
            temp[k] = array[j];
            j++;
            k++;
        }

        for (int l = low; l <= high; l++) {
            array[l] = temp[l];
        }
    }
}
