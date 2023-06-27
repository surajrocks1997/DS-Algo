package com.arrays;

public class nextPermutation {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 4, 3, 0, 0};
        solve(arr);

        for (int ele : arr) System.out.print(ele + " ");
    }

    private static void solve(int[] arr) {
        if (arr.length == 1) return;

        int i = -1;
        for (i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) break;
        }
        if (i == -1) {
            reverse(arr, 0, arr.length - 1);
            return;
        }

        for (int ind = arr.length - 1; ind >= i; ind--) {
            if (arr[ind] > arr[i]) {
                swap(arr, i, ind);
                break;
            }
        }
        reverse(arr, i+1, arr.length-1);
    }

    private static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            swap(arr, left++, right--);
        }
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}