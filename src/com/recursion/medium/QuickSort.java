package com.recursion.medium;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 5, 7, 9, 1, 3};
        solve(arr);
        Arrays.stream(arr).forEach(ele -> System.out.print(ele + " "));

    }

    private static void solve(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partition = partition(arr, low, high);
            quickSort(arr, low, partition - 1);
            quickSort(arr, partition + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int partition = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (i <= high && arr[i] <= partition) i++;
            while (j > low && arr[j] >= partition) j--;

            if (i < j) swap(arr, i, j);
        }

        swap(arr, low, j);

        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
