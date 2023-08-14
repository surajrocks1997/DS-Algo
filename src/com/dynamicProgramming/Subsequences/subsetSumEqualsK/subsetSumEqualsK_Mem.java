package com.dynamicProgramming.Subsequences.subsetSumEqualsK;

import java.util.Arrays;

public class subsetSumEqualsK_Mem {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int k = 9;
        int n = arr.length;

        boolean result = solve(n, k, arr);
        System.out.println(result);
    }

    private static boolean solve(int n, int k, int[] arr) {
        int[][] dp = new int[n][k + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return find(n - 1, k, arr, dp);
    }

    private static boolean find(int index, int target, int[] arr, int[][] dp) {
        if (target == 0) return true;
        if (index == 0) return arr[index] == target;

        if (dp[index][target] != -1)
            return dp[index][target] != 0;

        boolean pick = false;
        if (target >= arr[index])
            pick = find(index - 1, target - arr[index], arr, dp);

        boolean notPick = find(index - 1, target, arr, dp);

        dp[index][target] = pick || notPick ? 1 : 0;

        return pick || notPick;
    }
}
