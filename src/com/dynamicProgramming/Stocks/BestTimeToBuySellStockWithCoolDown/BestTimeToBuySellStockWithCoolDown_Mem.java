package com.dynamicProgramming.Stocks.BestTimeToBuySellStockWithCoolDown;

import java.util.Arrays;

public class BestTimeToBuySellStockWithCoolDown_Mem {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};

        int result = solve(prices);
        System.out.println(result);
    }

    private static int solve(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int[] rows : dp) Arrays.fill(rows, -1);
        return solve(0, 1, prices, dp);
    }

    private static int solve(int index, int canBuy, int[] prices, int[][] dp) {
        if (index >= prices.length) return 0;

        if (dp[index][canBuy] != -1) return dp[index][canBuy];

        int profit = 0;
        if (canBuy == 1) {
            int buy = -prices[index] + solve(index + 1, 0, prices, dp);
            int notBuy = solve(index + 1, 1, prices, dp);

            profit = Math.max(buy, notBuy);
        } else {
            int sell = prices[index] + solve(index + 2, 1, prices, dp);
            int notSell = solve(index + 1, 0, prices, dp);

            profit = Math.max(sell, notSell);
        }

        return dp[index][canBuy] = profit;
    }
}
