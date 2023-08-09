package com.dynamicProgramming.oneD.HouseRobberII;

import java.util.ArrayList;
import java.util.List;

public class HouseRobberII_Opt {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};

        int result = solve(nums);
        System.out.println(result);
    }

    private static int solve(int[] nums) {
        int n = nums.length;
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        if(n==1) return nums[0];

        for(int i = 0; i<n; i ++){
            if(i!= 0) arr1.add(nums[i]);
            if(i!=n-1) arr2.add(nums[i]);
        }

        int ans1 = solve(arr1);
        int ans2 = solve(arr2);

        return Math.max(ans1, ans2);
    }

    private static int solve(List<Integer> arr) {
        int n = arr.size();
        int prev = arr.get(0);
        int prev2 =0;

        for(int i=1; i<n; i++){
            int pick = arr.get(i);
            if(i>1)
                pick += prev2;
            int nonPick = 0 + prev;

            int cur_i = Math.max(pick, nonPick);
            prev2 = prev;
            prev= cur_i;

        }
        return prev;
    }

}
