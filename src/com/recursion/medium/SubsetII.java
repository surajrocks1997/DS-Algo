package com.recursion.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetII {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        List<List<Integer>> result = solve(arr);
        System.out.println(result);
    }

    private static List<List<Integer>> solve(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(arr);
        solve(0, arr, current, result);
        return result;
    }

    private static void solve(int index, int[] arr, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));

        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) continue;
            current.add(arr[i]);
            solve(i + 1, arr, current, result);
            current.remove(current.size() - 1);
        }
    }
}
