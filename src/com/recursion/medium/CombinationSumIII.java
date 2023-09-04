package com.recursion.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public static void main(String[] args) {
        int k = 9;
        int n = 45;

        List<List<Integer>> result = solve(k, n);
        System.out.println(result);
    }

    private static List<List<Integer>> solve(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        int index = 1;
        solve(index, k, n, curr, result);
        return result;
    }

    private static void solve(int index, int count, int target, List<Integer> curr, List<List<Integer>> result) {
        if (count == 0 && target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = index; i <= 9; i++) {
            if (i > target) break;
            curr.add(i);
            solve(i + 1, count - 1, target - i, curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}
