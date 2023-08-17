package com.dynamicProgramming.Subsequences.CountPartitionWithGivenDifference;

public class CountPartitionWithGivenDifference_Tab {
    public static void main(String[] args) {
        int[] arr = {1, 0, 8, 5, 1, 4};
        int n = 6;
        int d = 17;

        int result = solve(n, d, arr);
        System.out.println(result);
    }

    private static int solve(int n, int d, int[] arr) {
        int totalSum = 0;
        for (int ele : arr) totalSum += ele;
        if (totalSum - d < 0) return 0;
        if ((totalSum - d) % 2 == 1) return 0;

        int sum = (totalSum + d) / 2;
        int[][] dp = new int[n][sum + 1];

        if (arr[0] == 0) dp[0][0] = 2;
        else dp[0][0] = 1;

        if (arr[0] != 0 && arr[0] <= sum) dp[0][arr[0]] = 1;

        for (int index = 1; index < n; index++) {
            for (int target = 0; target <= sum; target++) {
                int notPick = dp[index - 1][target];

                int pick = 0;
                if (arr[index] <= target)
                    pick = dp[index - 1][target - arr[index]];

                dp[index][target] = (pick + notPick) % mod;
            }
        }

        return dp[n - 1][sum];
    }

    public static int mod = (int) 1e9 + 7;
}
