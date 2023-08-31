package com.arrays;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {1};

        solve(nums);
        Arrays.stream(nums).forEach(ele -> System.out.print(ele + " "));
    }

    private static void solve(int[] nums) {
        int i = 0;
        int j = 0;

        while (i < nums.length && nums[i] != 0) {
            i++;
        }
        j = i;

        while (j < nums.length) {
            if (i == j) {
                j++;
                continue;
            }

            if (nums[j] == 0)
                j++;
            else {
                swap(nums, i++, j);
            }

        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
