package com.arrays;

import java.util.Arrays;

public class nextPermutation {
    public static void main(String[] args) {
//        int[] arr = {2, 1, 5, 4, 3, 0, 0};
        int[] arr = {4, 2, 1, 3};
        solve(arr);

        for (int ele : arr) System.out.print(ele + " ");
    }

    private static void solve(int[] arr) { // logic is same as used in String->medium->NextGreaterNumberWithGivenSetOfNumber
        int i = 0;
        int n = arr.length;
        for (i = n - 1; i > 0; i--) {
            if (arr[i] > arr[i - 1])
                break;
        }

        int min = i;

        if (i == 0) {
            Arrays.sort(arr);
        } else {
            for (int index = i; index < n; index++) {
                if (arr[index] < arr[min] && arr[index] > arr[i - 1])
                    min = index;
            }

            int temp = arr[i - 1];
            arr[i - 1] = arr[min];
            arr[min] = temp;

            Arrays.sort(arr, i, n);
        }
    }
}