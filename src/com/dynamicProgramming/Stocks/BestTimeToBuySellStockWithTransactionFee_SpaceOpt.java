package com.dynamicProgramming.Stocks;

public class BestTimeToBuySellStockWithTransactionFee_SpaceOpt {
    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;

        int result = solve(prices, fee);
        System.out.println(result);
    }

    private static int solve(int[] prices, int fee) {
        int n = prices.length;
        int[] ahead = new int[2];
        int[] curr = new int[2];

        ahead[0] = 0;
        ahead[1] = 0;

        for (int index = n - 1; index >= 0; index--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                int profit = 0;
                if (canBuy == 1) {
                    int buy = -prices[index] + ahead[0];
                    int notBuy = ahead[1];

                    profit = Math.max(buy, notBuy);

                } else {
                    int sell = prices[index] - fee + ahead[1];
                    int notSell = ahead[0];

                    profit = Math.max(sell, notSell);
                }

                curr[canBuy] = profit;
            }
            ahead = curr;
        }

        return curr[1];
    }
}
