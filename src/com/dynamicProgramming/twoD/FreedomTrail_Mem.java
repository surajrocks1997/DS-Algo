package com.dynamicProgramming.twoD;


import java.util.Arrays;

//https://leetcode.com/problems/freedom-trail/description/
public class FreedomTrail_Mem {
    public static void main(String[] args) {
        String ring = "godding";
        String key = "gd";

        int result = solve(ring, key);
        System.out.println(result);
    }

    private static int solve(String ring, String key) {

        int[][] dp = new int[ring.length()][key.length()];
        for (int[] rows : dp) Arrays.fill(rows, -1);
        return solve(0, 0, ring, key, dp);
    }

    private static int solve(int ringIndex, int keyIndex, String ring, String key, int[][] dp) {
        if (keyIndex == key.length()) {
            return 0;
        }

        if (dp[ringIndex][keyIndex] != -1) return dp[ringIndex][keyIndex];

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < ring.length(); i++) {
            if (ring.charAt(i) == key.charAt(keyIndex)) {
                int minDist = Math.min(Math.abs(ringIndex - i), ring.length() - Math.abs(ringIndex - i));
                res = Math.min(res, minDist + 1 + solve(i, keyIndex + 1, ring, key, dp));
            }
        }

        return dp[ringIndex][keyIndex] = res;
    }
}
