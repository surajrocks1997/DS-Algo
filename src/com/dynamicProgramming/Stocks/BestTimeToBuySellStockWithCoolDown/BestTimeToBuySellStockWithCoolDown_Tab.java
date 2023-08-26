package com.dynamicProgramming.Stocks.BestTimeToBuySellStockWithCoolDown;

public class BestTimeToBuySellStockWithCoolDown_Tab {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};

        int result = solve(prices);
        System.out.println(result);
    }

    private static int solve(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 2][2];

        for (int index = n - 1; index >= 0; index--) {
            for (int canBuy = 0; canBuy < 2; canBuy++) {
                int profit = 0;
                if (canBuy == 1) {
                    int buy = -prices[index] + dp[index + 1][0];
                    int notBuy = dp[index + 1][1];

                    profit = Math.max(buy, notBuy);
                } else {
                    int sell = prices[index] + dp[index + 2][1];
                    int notSell = dp[index + 1][0];

                    profit = Math.max(sell, notSell);
                }

                dp[index][canBuy] = profit;
            }
        }

        return dp[0][1];
    }
}
