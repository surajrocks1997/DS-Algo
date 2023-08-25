package com.dynamicProgramming.Stocks.BestTimeToBuySellStockII;

import java.util.Arrays;

public class BestTimeToBuySellStockII_Mem {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};

        int result = solve(prices);
        System.out.println(result);
    }

    private static int solve(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int[] rows : dp) Arrays.fill(rows, -1);
        return solve(0, true, prices, dp);
    }

    private static int solve(int index, boolean canBuy, int[] prices, int[][] dp) {
        if (index == prices.length)
            return 0;

        if (dp[index][canBuy ? 1 : 0] != -1) return dp[index][canBuy ? 1 : 0];

        int profit = 0;
        if (canBuy) {
            int buy = -prices[index] + solve(index + 1, false, prices, dp);
            int notBuy = solve(index + 1, true, prices, dp);

            profit = Math.max(buy, notBuy);

        } else {
            int sell = prices[index] + solve(index + 1, true, prices, dp);
            int notSell = solve(index + 1, false, prices, dp);

            profit = Math.max(sell, notSell);
        }

        return dp[index][canBuy ? 1 : 0] = profit;
    }
}
