package com.greedy.medium;

// https://leetcode.com/problems/jump-game-ii
public class JumpGameII {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        int result = solve(nums);
        System.out.println(result);
    }

    private static int solve(int[] nums) {
        int result = 0;
        int l = 0;
        int r = 0;

        while(r < nums.length-1){
            int farthest = 0;
            for(int i = l; i <= r; i++)
                farthest = Math.max(farthest, i + nums[i]);

            l = r + 1;
            r = farthest;
            result++;
        }

        return result;
    }
}
