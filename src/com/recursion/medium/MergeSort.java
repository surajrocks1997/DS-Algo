package com.recursion.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {3, 2, 8, 5, 1, 4, 23};
        solve(arr);
        Arrays.stream(arr).forEach(ele -> System.out.print(ele + " "));
    }

    private static void solve(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) return;

        int mid = low + (high - low) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        List<Integer> list = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right])
                list.add(arr[left++]);
            else
                list.add(arr[right++]);
        }

        while (left <= mid)
            list.add(arr[left++]);

        while (right <= high)
            list.add(arr[right++]);

        for (int i = low; i <= high; i++) {
            arr[i] = list.get(i - low);
        }

    }
}
