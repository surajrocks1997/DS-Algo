package com.dynamicProgramming.Stocks.BestTimeToBuySellStockIII;

import java.util.Arrays;

public class BestTimeToBuySellStockIII_Mem {
    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};

        int result = solve(prices);
        System.out.println(result);
    }

    private static int solve(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for (int[][] twoD : dp)
            for (int[] rows : twoD) Arrays.fill(rows, -1);
        return solve(0, 1, 2, prices, dp);
    }

    private static int solve(int index, int canBuy, int cap, int[] prices, int[][][] dp) {
        if (cap == 0)
            return 0;
        if (index == prices.length) return 0;

        if (dp[index][canBuy][cap] != -1) return dp[index][canBuy][cap];

        int profit = 0;
        if (canBuy == 1) {
            int buy = -prices[index] + solve(index + 1, 0, cap, prices, dp);
            int notBuy = solve(index + 1, 1, cap, prices, dp);

            profit = Math.max(buy, notBuy);
        } else {
            int sell = prices[index] + solve(index + 1, 1, cap - 1, prices, dp);
            int notSell = solve(index + 1, 0, cap, prices, dp);

            profit = Math.max(sell, notSell);
        }

        return dp[index][canBuy][cap] = profit;
    }
}
