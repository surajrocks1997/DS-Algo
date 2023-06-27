package com.recursion.medium;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> result = solve(arr);
        System.out.println(result);
    }

    private static List<List<Integer>> solve(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] visited = new boolean[arr.length];
        solve(arr, current, result, visited);

        return result;
    }

    private static void solve(int[] arr, List<Integer> current, List<List<Integer>> result, boolean[] visited) {
        if (current.size() == arr.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                current.add(arr[i]);
                solve(arr, current, result, visited);
                visited[i] = false;
                current.remove(current.size() - 1);
            }
        }
    }
}
