package com.dynamicProgramming.Stocks.BestTimeToBuySellStockIII;

public class BestTimeToBuySellStockIII_SpaceOpt {
    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};

        int result = solve(prices);
        System.out.println(result);
    }

    private static int solve(int[] prices) {
        int n = prices.length;
        int[][] ahead = new int[2][3];
        int[][] curr = new int[2][3];

        //omitting base cases because every value is 0 itself, if it'd have been anything other than 1
        //then writing base case would have made sense

        for (int index = n - 1; index >= 0; index--) {
            for (int canBuy = 0; canBuy < 2; canBuy++) {
                for (int cap = 1; cap < 3; cap++) { //cap starting from 1 because at cap 0, value is 0 in baseCase.
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

        return ahead[1][2];
    }
}
