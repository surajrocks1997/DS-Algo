package com.StacksAndQueues.medium;

import java.util.Stack;

// https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/description/
public class FinalPriceWithSpecialDiscount {
    public static void main(String[] args) {
        int[] prices = {8, 4, 6, 2, 3};
        int[] result = solve(prices);
        for (int ele : result)
            System.out.print(ele + " ");

    }

    // used Monotonic stacks:  Next Smaller Element concept
    private static int[] solve(int[] prices) {
        int n = prices.length;
        Stack<Integer> nse = new Stack<>();

        int[] result = new int[n];
        result[n - 1] = prices[n - 1];
        nse.push(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            while (!nse.isEmpty() && prices[nse.peek()] >= prices[i])
                nse.pop();

            result[i] = !nse.isEmpty() ? prices[i] - prices[nse.peek()] : prices[i];
            nse.push(i);
        }

        return result;
    }
}