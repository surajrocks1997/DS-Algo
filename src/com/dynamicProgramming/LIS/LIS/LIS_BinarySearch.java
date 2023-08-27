package com.dynamicProgramming.LIS.LIS;

import java.util.ArrayList;
import java.util.List;

public class LIS_BinarySearch {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        int result = solve(nums);
        System.out.println(result);
    }

    private static int solve(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        int len = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > temp.get(temp.size() - 1)) {
                temp.add(nums[i]);
                len++;
            } else {
                int index = lowerBound(temp, nums[i]);
                temp.remove(index);
                temp.add(index, nums[i]);
            }
        }

        return len;
    }

    private static int lowerBound(List<Integer> list, int num) {
        int low = 0;
        int high = list.size() - 1;
        int mid;

        while (low < high) {
            mid = low + (high - low) / 2;

            if (num <= list.get(mid))
                high = mid;
            else
                low = mid + 1;
        }

        if (low < list.size() && list.get(low) < num)
            low++;

        return low;
    }
}
