package com.recursion.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation_SpaceOptimized {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> result = solve(arr);
        System.out.println(result);
    }

    private static List<List<Integer>> solve(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        solve(0, arr, result);

        return result;
    }

    private static void solve(int index, int[] arr, List<List<Integer>> result) {
        if (index >= arr.length) {
            List<Integer> current = new ArrayList<>();
            Arrays.stream(arr).forEach(current::add);
            result.add(current);
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, i, index);
            solve(index+1, arr, result);
            swap(arr, i, index);
        }
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
