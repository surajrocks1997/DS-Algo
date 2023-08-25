package com.dynamicProgramming.Stocks.BestTimeToBuySellStockII;

public class BestTimeToBuySellStockII_Rec {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};

        int result = solve(prices);
        System.out.println(result);
    }

    private static int solve(int[] prices) {
        return solve(0, true, prices);
    }

    private static int solve(int index, boolean canBuy, int[] prices) {
        if (index == prices.length)
            return 0;

        int profit = 0;
        if (canBuy) {
            int buy = -prices[index] + solve(index + 1, false, prices);
            int notBuy = solve(index + 1, true, prices);

            profit = Math.max(buy, notBuy);

        } else {
            int sell = prices[index] + solve(index + 1, true, prices);
            int notSell = solve(index + 1, false, prices);

            profit = Math.max(sell, notSell);
        }

        return profit;
    }
}
