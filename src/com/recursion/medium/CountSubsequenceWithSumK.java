package com.recursion.medium;

import java.util.ArrayList;
import java.util.List;

public class CountSubsequenceWithSumK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        int k = 3;
        int result = solve(arr, k);
        System.out.println(result);
    }

    private static int solve(int[] arr, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        return solve(arr, 0, 0, k);

    }

    private static int solve(int[] arr, int index, int sum, int k) {
        if (index >= arr.length) {
            if (sum == k) {
                return 1;
            }
            return 0;
        }

        sum += arr[index];
        int left = solve(arr, index + 1, sum, k);

        sum -= arr[index];
        int right = solve(arr, index + 1, sum, k);

        return left + right;

    }
}
