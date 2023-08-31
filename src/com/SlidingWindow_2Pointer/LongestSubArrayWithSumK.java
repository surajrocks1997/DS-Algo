package com.SlidingWindow_2Pointer;

public class LongestSubArrayWithSumK {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 1, 1, 1, 1};
        int k = 3;

        int result = solve(a, k);
        System.out.println(result);
    }

    private static int solve(int[] a, int k) {
        int windowStart = 0;
        int max = 0;
        long sum = 0;

        for (int windowEnd = 0; windowEnd < a.length; windowEnd++) {
            sum += a[windowEnd];

            if (sum > k) {
                while (sum > k) sum -= a[windowStart++];
            }
            if (sum == k)
                max = Math.max(max, windowEnd - windowStart + 1);
        }
        return max;
    }
}
