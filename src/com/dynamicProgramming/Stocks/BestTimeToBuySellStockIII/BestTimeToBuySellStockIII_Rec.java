package com.dynamicProgramming.Stocks.BestTimeToBuySellStockIII;

public class BestTimeToBuySellStockIII_Rec {
    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};

        int result = solve(prices);
        System.out.println(result);
    }

    private static int solve(int[] prices) {
        return solve(0, 1, 2, prices);
    }

    private static int solve(int index, int canBuy, int cap, int[] prices) {
        if(cap == 0)
            return 0;
        if(index == prices.length) return 0;


        int profit = 0;
        if (canBuy == 1) {
            int buy = -prices[index] + solve(index + 1, 0, cap, prices);
            int notBuy = solve(index + 1, 1, cap, prices);

            profit = Math.max(buy, notBuy);
        } else {
            int sell = prices[index] + solve(index + 1, 1, cap - 1, prices);
            int notSell = solve(index + 1, 0, cap, prices);

            profit = Math.max(sell, notSell);
        }

        return profit;
    }
}
