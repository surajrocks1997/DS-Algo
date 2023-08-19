package com.dynamicProgramming.Subsequences.RodCuttingProblem;

public class RodCuttingProblem_Tab {
    public static void main(String[] args) {
        int[] price = {3, 5, 6, 7, 10, 12};
        int n = 6;

        int result = solve(price, n);
        System.out.println(result);

    }

    private static int solve(int[] price, int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int count = 1; count <= n; count++)
            dp[1][count] = count * price[0];

        for (int index = 2; index <= n; index++) {
            for (int count = 1; count <= n; count++) {
                int notPick = dp[index - 1][count];

                int pick = 0;
                if (count >= index)
                    pick = price[index - 1] + dp[index][count - index];

                dp[index][count] = Math.max(pick, notPick);
            }
        }
        return dp[n][n];
    }
}
