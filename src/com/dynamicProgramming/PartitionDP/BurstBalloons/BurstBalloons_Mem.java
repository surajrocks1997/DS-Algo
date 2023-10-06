package com.dynamicProgramming.PartitionDP.BurstBalloons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BurstBalloons_Mem {
    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};

        int result = solve(nums);
        System.out.println(result);
    }

    private static int solve(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.stream(nums).forEach(list::add);
        list.add(0, 1);
        list.add(1);
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int[] rows : dp) Arrays.fill(rows, -1);
        return solve(1, n, list, dp);
    }

    private static int solve(int i, int j, List<Integer> list, int[][] dp) {
        if (i > j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int max = Integer.MIN_VALUE;
        for (int index = i; index <= j; index++) {
            int coins = list.get(i - 1) * list.get(index) * list.get(j + 1) +
                    solve(i, index - 1, list, dp) + solve(index + 1, j, list, dp);

            max = Math.max(coins, max);

        }
        return dp[i][j] = max;
    }
}
