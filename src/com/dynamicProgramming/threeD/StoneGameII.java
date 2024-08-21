package com.dynamicProgramming.threeD;

import java.util.Arrays;

//https://leetcode.com/problems/stone-game-ii
public class StoneGameII {
    public static void main(String[] args) {
        int[] piles = {2, 7, 9, 4, 4};
        int result = solve(piles);
        System.out.println(result);
    }

    private static int solve(int[] piles) {
        int n = piles.length;
        int[][][] dp = new int[n + 1][n + 1][2];
        for (int[][] twoD : dp) {
            for (int[] rows : twoD)
                Arrays.fill(rows, -1);
        }
        return helper(0, 1, piles, 1, dp);
    }

    private static int helper(int index, int M, int[] piles, int aliceChance, int[][][] dp) {
        if (index >= piles.length) return 0;

        if (dp[index][M][aliceChance] != -1) return dp[index][M][aliceChance];

        int count = aliceChance == 1 ? 0 : Integer.MAX_VALUE;
        for (int i = 1; i <= 2 * M; i++) {
            if (aliceChance == 1) {
                count = Math.max(count, countStone(piles, index, index + i - 1) + helper(index + i, Math.max(M, i), piles, 0, dp));
            } else {
                count = Math.min(count, helper(index + i, Math.max(M, i), piles, 1, dp));
            }
        }
        return dp[index][M][aliceChance] = count;
    }

    private static int countStone(int[] piles, int start, int end) {
        int count = 0;
        while (start < piles.length && start <= end) {
            count += piles[start++];
        }

        return count;
    }
}
