package com.dynamicProgramming.PartitionDP.MCM;

public class MCM_Rec {
    public static void main(String[] args) {
        int[] p = {10, 15, 20, 25};

        int result = solve(p);
        System.out.println(result);
    }

    private static int solve(int[] p) {
        return solve(1, p.length - 1, p);
    }

    private static int solve(int i, int j, int[] arr) {
        if (i == j) return 0;

        int min = (int) 1e9;
        for (int k = i; k < j; k++) {
            int steps = arr[i - 1] * arr[k] * arr[j] +
                    solve(i, k, arr) + solve(k + 1, j, arr);

            min = Math.min(min, steps);
        }
        return min;
    }
}
