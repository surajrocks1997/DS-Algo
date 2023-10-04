package com.dynamicProgramming.MCM.MinCostToCutStick;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinCostToCutStick_Mem {
    public static void main(String[] args) {
        int n = 7;
        int[] cuts = {3, 5, 1, 4};

        int result = solve(cuts, n);
        System.out.println(result);
    }

    private static int solve(int[] cuts, int n) {
        List<Integer> myCuts = new ArrayList<>();
        Arrays.stream(cuts).forEach(myCuts::add);
        myCuts.add(0);
        myCuts.add(n);
        Collections.sort(myCuts);
        int[][] dp = new int[cuts.length + 1][cuts.length + 1];
        for (int[] rows : dp) Arrays.fill(rows, -1);
        return solve(1, cuts.length, myCuts, dp);
    }

    private static int solve(int i, int j, List<Integer> myCuts, int[][] dp) {
        if (i > j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE;
        for (int index = i; index <= j; index++) {
            int cost = myCuts.get(j + 1) - myCuts.get(i - 1) +
                    solve(i, index - 1, myCuts, dp) + solve(index + 1, j, myCuts, dp);

            min = Math.min(min, cost);
        }
        return dp[i][j] = min;
    }
}
