package com.dynamicProgramming.Stocks;

public class BestTimeToBuySellStockIV {
    public static void main(String[] args) {
        int[] prices = {2, 4, 1};
        int k = 2;

        int result = solve(prices, k);
        System.out.println(result);
    }

    private static int solve(int[] prices, int k) {
        int n = prices.length;
        int[][] ahead = new int[2][k+1];
        int[][] curr = new int[2][k+1];

        //omitting base cases because every value is 0 itself, if it'd have been anything other than 1
        //then writing base case would have made sense

        for (int index = n - 1; index >= 0; index--) {
            for (int canBuy = 0; canBuy < 2; canBuy++) {
                for (int cap = 1; cap <= k; cap++) { //cap starting from 1 because at cap 0, value is 0 in baseCase.
                    int profit = 0;
                    if (canBuy == 1) {
                        int buy = -prices[index] + ahead[0][cap];
                        int notBuy = ahead[1][cap];

                        profit = Math.max(buy, notBuy);
                    } else {
                        int sell = prices[index] + ahead[1][cap - 1];
                        int notSell = ahead[0][cap];

                        profit = Math.max(sell, notSell);
                    }

                    curr[canBuy][cap] = profit;
                }
                ahead = curr;
            }
        }

        return ahead[1][k];
    }
}
