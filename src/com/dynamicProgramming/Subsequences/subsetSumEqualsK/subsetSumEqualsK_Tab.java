package com.dynamicProgramming.Subsequences.subsetSumEqualsK;

public class subsetSumEqualsK_Tab {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int k = 9;
        int n = arr.length;

        boolean result = solve(n, k, arr);
        System.out.println(result);
    }

    private static boolean solve(int n, int k, int[] arr) {
        boolean[][] dp = new boolean[n][k + 1];
        for (int i = 0; i < n; i++)
            dp[i][0] = true;

        if (k >= arr[0])
            dp[0][arr[0]] = true;

        for (int index = 1; index < n; index++) {
            for (int target = 1; target <= k; target++) {
                boolean taken = false;
                if (target >= arr[index])
                    taken = dp[index - 1][target - arr[index]];

                boolean notTaken = dp[index - 1][target];
                dp[index][target] = notTaken || taken;
            }
        }

        return dp[n - 1][k];
    }
}
