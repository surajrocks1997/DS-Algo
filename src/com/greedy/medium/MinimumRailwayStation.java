package com.greedy.medium;

import java.util.Arrays;

public class MinimumRailwayStation {
    public static void main(String[] args) {
        int[] arr = {900, 945, 955, 1100, 1500, 1800};
        int[] dep = {920, 1200, 1130, 1150, 1900, 2000};
        int n = arr.length;
        int totalCount = solve(arr, dep, n);
        System.out.println(totalCount);
    }

    private static int solve(int[] arr, int[] dep, int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int maxPlatform = 1;
        int count = 1;
        int start = 1;
        int end = 0;

        while(start < n && end < n){
            if(arr[start] > dep[end]){
                count--;
                end++;
            } else {
                start++;
                count++;
            }

            maxPlatform = Math.max(maxPlatform, count);
        }

        return maxPlatform;
    }
}
