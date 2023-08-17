package com.dynamicProgramming.Subsequences.CountSubsetsWithSumK;

public class CountSubsetsWithSumK_Rec {
    public static void main(String[] args) {
        int[] num = {2, 34, 5};
        int tar = 40;

        int result = solve(num, tar);
        System.out.println(result);
    }

    private static int solve(int[] num, int tar) {
        return solve(num.length - 1, tar, num);
    }

    private static int solve(int index, int k, int[] num) {
        if (k == 0) return 1;
        if (index == 0) return k == num[index] ? 1 : 0;

        int notPick = solve(index - 1, k, num);
        int pick = 0;
        if (num[index] <= k)
            pick = solve(index - 1, k - num[index], num);

        return pick + notPick;
    }
}
