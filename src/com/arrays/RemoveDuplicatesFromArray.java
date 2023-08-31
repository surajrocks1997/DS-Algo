package com.arrays;

import java.util.Arrays;

public class RemoveDuplicatesFromArray {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        int result = solve(nums);
        System.out.println(result);
        Arrays.stream(nums).forEach(ele -> System.out.print(ele + " "));
    }

    private static int solve(int[] nums) {
        int i = 0;
        int j = 0;

        while (j < nums.length) {
            if (i == j) {
                j++;
                continue;
            }

            if (nums[i] == nums[j])
                j++;
            else {
                nums[++i] = nums[j++];
            }

        }
        return i + 1;
    }
}
