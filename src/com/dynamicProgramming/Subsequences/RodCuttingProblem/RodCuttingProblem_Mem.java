package com.dynamicProgramming.Subsequences.RodCuttingProblem;

public class RodCuttingProblem_Mem {
    public static void main(String[] args) {
        int[] price = {3, 5, 6, 7, 10, 12};
        int n = 6;

        int result = solve(price, n);
        System.out.println(result);

    }

    private static int solve(int[] price, int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= n; j++)
                dp[i][j] = -1;
        return solve(n, n, price, dp);
    }

    private static int solve(int index, int count, int[] price, int[][] dp) {
        if (index - 1 == 0)
            return count / index * price[index - 1];

        if (dp[index][count] != -1) return dp[index][count];

        int notPick = solve(index - 1, count, price, dp);
        int pick = 0;
        if (count >= index)
            pick = price[index - 1] + solve(index, count - index, price, dp);
        return dp[index][count] = Math.max(pick, notPick);
    }
}
