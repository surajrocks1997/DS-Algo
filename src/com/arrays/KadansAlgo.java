package com.arrays;

public class KadansAlgo {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = solve(nums);
        System.out.println(result);
    }

    private static int solve(int[] arr) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int startI = 0;
        int maxWindow = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum > max) {
                max = sum;
                maxWindow = Math.max(maxWindow, i - startI);
                System.out.println(i + " " + startI);
            }

            if (sum < 0) {
                sum = 0;
                startI = i;
            }
        }
        System.out.println("Max Window: " + maxWindow);
        return max;
    }
}
