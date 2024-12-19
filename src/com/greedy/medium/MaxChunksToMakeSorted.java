package com.greedy.medium;

// https://leetcode.com/problems/max-chunks-to-make-sorted/description/
public class MaxChunksToMakeSorted {

    public static void main(String[] args) {
        int[] arr = {1,0,2,3,4};
        int result = solve(arr);
        System.out.println(result);
    }

    private static int solve(int[] arr) {
        int n = arr.length;
        int prefixSum = 0;
        int sum = 0;
        int result = 0;

        for(int i = 0; i < n; i++){
            sum += i;
            prefixSum += arr[i];
            if(sum == prefixSum) result++;
        }
        return result;
    }
}
