package com.recursion.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static void main(String[] args) {
        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> result = solve(arr, target);
        System.out.println(result);
    }

    private static List<List<Integer>> solve(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(arr);

        solve(0, arr, target, current, result);

        return result;
    }

    private static void solve(int index, int[] arr, int target, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) continue;
            if (arr[i] > target) break;

            current.add(arr[i]);
            solve(i + 1, arr, target - arr[i], current, result);
            current.remove(current.size() - 1);
        }
    }
}
