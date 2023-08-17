package com.dynamicProgramming.Subsequences.CountPartitionWithGivenDifference;

public class CountPartitionWithGivenDifference_Mem {
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

        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[0].length; j++)
                dp[i][j] = -1;

        return find(n - 1, sum, arr, dp);
    }

    public static int mod = (int) 1e9 + 7;

    private static int find(int index, int sum, int[] arr, int[][] dp) {
        if (index == 0) {
            if (sum == 0 && arr[0] == 0)
                return 2;
            if (sum == 0 || sum == arr[0])
                return 1;
            return 0;
        }

        if (dp[index][sum] != -1) return dp[index][sum];

        int pick = 0;
        if (sum >= arr[index])
            pick = find(index - 1, sum - arr[index], arr, dp);
        int notPick = find(index - 1, sum, arr, dp);
        return dp[index][sum] = (pick + notPick) % mod;
    }
}
