package com.dynamicProgramming.twoD.PerfectSquares;


// tabulation code not working

public class PerfectSquares_Tab {

    public static void main(String[] args) {
        int n = 15;
        int result = solve(n);
        System.out.println(result);
    }

    private static int solve(int num) {
        int y = (int) Math.sqrt(num);
        int[][] dp = new int[num + 1][y + 1];

        for (int i = 0; i < num + 1; i++) {
            for (int j = 0; j < y + 1; j++) {
                if (i <= 3)
                    dp[i][j] = i;
            }
        }

        for (int n = num; n > 1; n--) {

            int min = Integer.MAX_VALUE;
            for (int sqrt = y; sqrt >= 2; sqrt--) {
                int x = n - (int) Math.pow(sqrt, 2);
                min = Math.min(min, dp[x][(int) Math.sqrt(x)]);

                dp[n][sqrt] = 1 + min;
            }


        }


        return dp[num][y];
    }

    private static int solve(int n, int sqrt, int[][] dp) {
        if (n <= 3) return n;

        if (dp[n][sqrt] != -1) return dp[n][sqrt];

        int min = Integer.MAX_VALUE;
        for (int i = sqrt; i >= 2; i--) {
            int x = n - (int) Math.pow(i, 2);
            min = Math.min(min, solve(x, (int) Math.sqrt(x), dp));
        }

        return dp[n][sqrt] = 1 + min;

    }
}