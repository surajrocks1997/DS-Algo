package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class de_shaw_hackerrank_dp {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(8, 9, 1, 8, 2));
        int k = 3;
        int mx = 10;
        int max_cost = 12;

        int result = solve(arr, mx, k, max_cost);
        System.out.println(result);

    }

    private static int solve(List<Integer> arr, int mx, int k, int max_cost) {
        int[][] dp = new int[arr.size()][max_cost + 1];
        for (int[] rows : dp) Arrays.fill(rows, -1);
        return solve(arr, mx, k, max_cost, 0, true, dp);
    }

    private static int solve(List<Integer> arr, int mx, int k, int maxCost, int index, boolean isNext, int[][] dp) {
        if (index == arr.size() || maxCost < 0)
            return 0;

        if (dp[index][maxCost] != -1) return dp[index][maxCost];

        int pick = 0;
        if (maxCost - (mx - arr.get(index)) >= 0) {
            if (isNext)
                pick = 1 + solve(arr, mx, k, maxCost - (mx - arr.get(index)), index + 1, true, dp);
            else
                pick = 1 + solve(arr, mx, k, maxCost - (k + mx - arr.get(index)), index + 1, false, dp);
        }

        int notPick = solve(arr, mx, k, maxCost, index + 1, false, dp);

        return dp[index][maxCost] = Math.max(pick, notPick);
    }
}
