package com.example.leetcode;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
       int[] array = {4,5,6,3,2,1};
       BubbleSort bubbleSort = new BubbleSort();
       bubbleSort.bubbleSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    private void bubbleSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if(array[i]>array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
