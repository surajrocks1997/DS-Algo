package com.recursion.medium;

import java.util.ArrayList;
import java.util.List;

public class AnyOneSubsequenceWithSumK {
    public static void main(String[] args) {
        int[] arr = {2, 2, 4 };
        int k = 3;
        List<List<Integer>> result = solve(arr, k);
        System.out.println(result);
    }

    private static List<List<Integer>> solve(int[] arr, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        solve(arr, current, result, 0, 0, k);
        return result;
    }

    private static boolean solve(int[] arr, List<Integer> current, List<List<Integer>> result, int index, int sum, int k) {
        if (index >= arr.length) {
            if (sum == k) {
                result.add(new ArrayList<>(current));
                return true;
            }
            return false;
        }

        current.add(arr[index]);
        sum += arr[index];
        if (solve(arr, current, result, index + 1, sum, k)) return true;

        current.remove(current.size() - 1);
        sum -= arr[index];
        return solve(arr, current, result, index + 1, sum, k);

    }
}
