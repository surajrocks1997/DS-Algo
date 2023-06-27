package com.recursion.easy;

public class SortArray {
    public static void main(String[] args) {
        int[] arr = {10, 4, 1, 5, 8, 2};
        for (int ele : solve(arr)) {
            System.out.print(ele + " ");
        }
    }

    private static int[] solve(int[] arr) {
        return sort(arr, arr.length - 1);
    }

    private static int[] sort(int[] arr, int index) {
        if (index == 0) return arr;

        for (int i = 0; i < index; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        return sort(arr, index - 1);


    }
}
