package com.important;

public class TrappingRainWater_Optimized {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int sum = solve(height);
        System.out.println(sum);
    }

    private static int solve(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int result = 0;
        int maxLeft = 0;
        int maxRight = 0;

        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= maxLeft)
                    maxLeft = height[left];
                else
                    result += maxLeft - height[left];

                left++;

            } else {
                if (height[right] >= maxRight)
                    maxRight = height[right];
                else
                    result += maxRight - height[right];

                right--;
            }
        }

        return result;
    }
}
