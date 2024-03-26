package com.arrays.hard;

public class FindFirstMissingPositiveNumber {
    public static void main(String[] args) {
        int[] nums = {1, 1}; // {3,4,-1,1}
        int result = solve(nums);
        System.out.println(result);
    }

    private static int solve(int[] nums) {
        int n = nums.length;
        int i = 0;

        while (i < n) {

            //checks if the current ele - 1 == i, e.g if 1, is it already in index 0 (nums[i] -1 == i)? OR
            // if nums[i]-1 lies outside the range [0-n) then simply increase index
            if (nums[i] - 1 == i || nums[i] - 1 >= n || nums[i] - 1 < 0)
                i++;

                // else, check if the swapping number is duplicate, e.g [1,1]. in this case, no reason for swap value 1 at index 1 as at index 0, 1 is already there. so i++ and continue
                // if above if condition doesn't meets, just swap and put into right index
            else {
                if (nums[i] == nums[nums[i] - 1]) {
                    i++;
                    continue;
                }

                swap(i, nums[i] - 1, nums);

            }
        }

        for (i = 0; i < n; i++) {
            if (nums[i] - 1 != i)
                return i + 1;
        }

        return i + 1;
    }

    private static void swap(int left, int right, int[] nums) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
