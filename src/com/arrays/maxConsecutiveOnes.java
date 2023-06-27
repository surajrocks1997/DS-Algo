package com.arrays;

public class maxConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1};
        int result = solve(arr);
        System.out.println(result);
    }

    private static int solve(int[] arr) {
        int max = 0;
        int count = 0;
        for (int x : arr) {
            if (x == 1) {
                count++;
                max = Math.max(max, count);
            } else count = 0;

        }
        return max;
    }
}
