package com.dynamicProgramming.Stocks;

public class BestTImeToBuySellStock {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};

        int result = solve(prices);
        System.out.println(result);
    }

    private static int solve(int[] prices) {
        int minSoFar = prices[0];
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            int profit = prices[i] - minSoFar;
            maxProfit = Math.max(maxProfit, profit);
            minSoFar = Math.min(minSoFar, prices[i]);
        }
        return maxProfit;
    }
}
