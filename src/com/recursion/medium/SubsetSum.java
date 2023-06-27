package com.recursion.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2};
        List<Integer> result = solve(arr);
        System.out.println(result);
    }

    private static List<Integer> solve(int[] arr) {
        List<Integer> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        solve(0, 0, arr, result);
        Collections.sort(result);
        return result;
    }

    private static void solve(int index, int sum, int[] arr, List<Integer> result) {
        if (index >= arr.length) {
            result.add(sum);
            return;
        }

        solve(index + 1, sum + arr[index], arr, result);
        solve(index + 1, sum, arr, result);


    }
}
