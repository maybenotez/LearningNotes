package com.dark.knight.learn.algorithms.sort;

public class HeapSort implements Sort{


    /**
     * 1
     * 2,3
     * 4,5,6,7
     * 8,9,10,11,12,13,14
     *
     */
    @Override
    public void sort(int[] array) {
        // 建堆  最大堆 堆顶元素 最大
        heapBuild(array, 0, array.length - 1);
        int len = array.length - 1;
        while(len >=0){
            // 交换堆顶与最后一个元素  此时最大的元素在数组的最后一位
            swap(array, 0, len);
            len--;
            // 堆调整
            heapBuild(array, 0, len);
        }
    }


    private void heapBuild(int[] array, int low, int high) {
        if (low == high) {
            return;
        }
        int lastRoot = (high-1)/2;
        while(lastRoot >= low){
            adjust(array, lastRoot, high);
            lastRoot--;
        }
    }

    private void adjust(int[] array,int root,int high){
        int child1 = 2* root + 1;
        int child2 = 2* root + 2;

        int max = root;
        if(child1 <= high && array[max] < array[child1]){
            max = child1;
        }

        if(child2 <= high && array[max] < array[child2]){
            max = child2;
        }
        if(max != root){
            swap(array, root, max);
            adjust(array, max, high);
        }

    }
}
