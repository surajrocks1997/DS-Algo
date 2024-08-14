package com.binarySearch.BSinSearchSpace;

import java.util.Arrays;

// https://leetcode.com/problems/find-k-th-smallest-pair-distance/description/
public class FindKthSmallestPairDistance {

    public static void main(String[] args) {
        int[] nums = {1,6,1};
        int k = 3;
        int result = solve(nums, k);
        System.out.println(result);
    }

    private static int solve(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        int max = nums[n-1];
        int low = 0;
        int high = max;

        // low and high are the differences
        // we are trying to find number of pairs we have with a given difference.
        // if number of pairs with a difference comes to be < k, then we increase the difference i.e. low = mid+1
        // else lets say k = 7, but we found there are 14 pairs with the given difference, then we do high = mid
        while(low < high){
            int mid = low + (high - low)/2;

            int pairs = helper(mid, nums);
            if(pairs < k)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }

    private static int helper(int difference, int[] nums){
        int left = 0;
        int right = 1;
        int countPairs = 0;

        while(right < nums.length && left <= right){
            if(nums[right] - nums[left] <= difference){
                countPairs += right - left;
                right++;
            } else {
                left++;
            }
        }

        return countPairs;
    }
}