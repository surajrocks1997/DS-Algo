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
        int right = n-1;

        int leftMax = 0;
        int rightMax = 0;

        int ans = 0;

        while(left < right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if(leftMax < rightMax){
                ans += leftMax - height[left++];
            } else
                ans += rightMax - height[right--];
        }

        return ans;
    }
}
