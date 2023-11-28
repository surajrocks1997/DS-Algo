package com.arrays;

import java.util.ArrayList;
import java.util.List;

public class CountInversions {

    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 4, 1};
        int result = solve(arr);
        System.out.println(result);
    }

    private static int solve(int[] arr) {
        return modifiedMergeSort(0, arr.length - 1, arr);
    }

    private static int modifiedMergeSort(int low, int high, int[] arr) {
        int count = 0;
        if (low >= high) {
            return count;
        }

        int middle = low + (high - low) / 2;
        count += modifiedMergeSort(low, middle, arr);
        count += modifiedMergeSort(middle + 1, high, arr);
        return count + merge(low, middle, high, arr);
    }

    private static int merge(int low, int mid, int high, int[] arr) {
        List<Integer> list = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        int count = 0;
        while (left <= mid && right <= high) {
            if (arr[left] > arr[right]) {
                count += mid - left + 1;
                list.add(arr[right++]);
            } else
                list.add(arr[left++]);
        }

        while (left <= mid) {
            list.add(arr[left++]);
        }

        while (right <= high) {
            list.add(arr[right++]);
        }

        for (int i = low; i <= high; i++) {
            arr[i] = list.get(i - low);
        }

        return count;
    }
}
