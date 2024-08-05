package com.dynamicProgramming;

import java.util.Arrays;

// https://leetcode.com/problems/filling-bookcase-shelves/description/
public class FillingBookcaseShelves {

    public static void main(String[] args) {
        int[][] books = {
                {1, 1},
                {2, 3},
                {2, 3},
                {1, 1},
                {1, 1},
                {1, 1},
                {1, 2}
        };
        int shelfWidth = 4;
        int result = solve(books, shelfWidth);
        System.out.println(result);
    }

    private static int solve(int[][] books, int shelfWidth) {
        int n = books.length;
        int[][] dp = new int[n][shelfWidth + 1];
        for (int[] rows : dp)
            Arrays.fill(rows, -1);
        return helper(books, shelfWidth, 0, shelfWidth, 0, dp);
    }

    private static int helper(int[][] books, int shelfWidth, int index, int remWidth, int currHeight, int[][] dp) {
        if (index == books.length) return currHeight;

        if (dp[index][remWidth] != -1) return dp[index][remWidth];

        int newShelfHeight = currHeight + helper(books, shelfWidth, index + 1, shelfWidth - books[index][0], books[index][1], dp);

        int currentShelfHeight = Integer.MAX_VALUE;
        if (remWidth >= books[index][0]) {
            int newMaxHeight = Math.max(currHeight, books[index][1]);
            currentShelfHeight = helper(books, shelfWidth, index + 1, remWidth - books[index][0], newMaxHeight, dp);
        }

        return dp[index][remWidth] = Math.min(newShelfHeight, currentShelfHeight);

    }
}