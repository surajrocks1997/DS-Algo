package com.dynamicProgramming.PartitionDP.MinCostToCutStick;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinCostToCutStick_Tab {
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
        int[][] dp = new int[cuts.length + 2][cuts.length + 2];

//        base cases not required as it is equal to 0

        for (int i = cuts.length; i >= 1; i--) {
            for (int j = 1; j <= cuts.length; j++) {
                if (i > j) continue;
                int min = Integer.MAX_VALUE;
                for (int index = i; index <= j; index++) {
                    int cost = myCuts.get(j + 1) - myCuts.get(i - 1) +
                            dp[i][index - 1] + dp[index + 1][j];

                    min = Math.min(min, cost);
                }
                dp[i][j] = min;
            }
        }

        return dp[1][cuts.length];
    }
}
