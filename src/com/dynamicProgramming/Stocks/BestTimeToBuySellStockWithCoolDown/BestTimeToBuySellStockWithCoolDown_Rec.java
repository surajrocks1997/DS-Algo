package com.dynamicProgramming.Stocks.BestTimeToBuySellStockWithCoolDown;

public class BestTimeToBuySellStockWithCoolDown_Rec {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};

        int result = solve(prices);
        System.out.println(result);
    }

    private static int solve(int[] prices) {
        int n = prices.length;
        return solve(0, 1, prices);
    }

    private static int solve(int index, int canBuy, int[] prices) {
        if (index >= prices.length) return 0;

        int profit = 0;
        if (canBuy == 1) {
            int buy = -prices[index] + solve(index + 1, 0, prices);
            int notBuy = solve(index + 1, 1, prices);

            profit = Math.max(buy, notBuy);
        } else {
            int sell = prices[index] + solve(index + 2, 1, prices);
            int notSell = solve(index + 1, 0, prices);

            profit = Math.max(sell, notSell);
        }

        return profit;
    }
}
