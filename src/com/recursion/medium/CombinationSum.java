package com.recursion.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] arr = {2,3,6,7};
        int target = 7;

        List<List<Integer>> result = solve(arr, target);
        System.out.println(result);
    }

    private static List<List<Integer>> solve(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        solve(0, target, arr, current, result);

        return result;
    }

    private static void solve(int index, int target, int[] arr, List<Integer> current, List<List<Integer>> result) {
        if (index == arr.length) {
            if (target == 0)
                result.add(new ArrayList<>(current));

            return;
        }

        if (arr[index] <= target) {
            current.add(arr[index]);
            solve(index, target - arr[index], arr, current, result);
            current.remove(current.size() - 1);
        }
        solve(index + 1, target, arr, current, result);

    }
}
