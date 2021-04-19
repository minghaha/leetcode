package com.example.leetcode;

/**
 * 快速排序
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {4, 5, 6, 3, 2, 1};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.insertionSort(array, array.length);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public void insertionSort(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            int value = a[i];
            for (int j = i - 1; j >= 0; j--) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                    a[j] = value;
                } else {
//                    break;
                }
            }
        }
    }
}
