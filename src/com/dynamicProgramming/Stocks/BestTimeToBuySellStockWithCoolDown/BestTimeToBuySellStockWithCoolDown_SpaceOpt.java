package com.dynamicProgramming.Stocks.BestTimeToBuySellStockWithCoolDown;

public class BestTimeToBuySellStockWithCoolDown_SpaceOpt {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};

        int result = solve(prices);
        System.out.println(result);
    }

//    not giving right ans
    private static int solve(int[] prices) {
        int n = prices.length;
        int[] front2 = new int[2];
        int[] front1 = new int[2];
        int[] curr = new int[2];

        for (int index = n - 1; index >= 0; index--) {
            for (int canBuy = 0; canBuy < 2; canBuy++) {
                int profit = 0;
                if (canBuy == 1) {
                    int buy = -prices[index] + front1[0];
                    int notBuy = front1[1];

                    profit = Math.max(buy, notBuy);
                } else {
                    int sell = prices[index] + front2[1];
                    int notSell = front1[0];

                    profit = Math.max(sell, notSell);
                }

                curr[canBuy] = profit;
            }
            front2 = front1;
            front1 = curr;
        }

        return curr[1];
    }
}
